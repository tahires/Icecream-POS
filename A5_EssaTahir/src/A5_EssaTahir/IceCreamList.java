/** Name:  Essa Tahir
 * Assignment:  Assignment5
 * Program: PROG24178
 *
 * Making a icecream inventory
 */
package A5_EssaTahir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;

/*
*Icecreamlist class which extends arraylist icecream
 */
public class IceCreamList extends ArrayList<IceCream> {

    /*
    *Variable to read and write
     */
    File file;
    Scanner input;
    IceCream item;

    /*
    *contructor to call readfile
     */
    public IceCreamList() throws IOException {
        this.readFile();

    }

    /*
    *method for reading the file
    *show the text file
     */

    public void readFile() throws IOException {

        this.file = new File("text.txt");
        this.input = new Scanner(this.file);

        IceCreamFlavour[] flavour = IceCreamFlavour.values();
        this.input.useDelimiter("\\|\\s*");

        /*
        *while loop for the input
         */
        while (this.input.hasNext()) {
            this.item = new IceCream();
            int index = this.input.nextInt();
//            this.item.setFlavour(IceCreamFlavour.BUTTER_PECAN); 
            this.item.setFlavour(flavour[index - 1]);
            this.input.next();
//            this.item.setPrice(9.9);
            this.item.setPrice(this.input.nextDouble());
//            this.item.setQuantity(5);
            this.item.setQuantity(this.input.nextInt());
            this.input.nextDouble();
            add(this.item);
        }

        this.input.close();

    }

    /*
    *for writing record in the text.txt
     */

    public void writeRecord(IceCream item) throws Exception {

        this.file = new File("text.txt");
        IceCreamFlavour[] list = IceCreamFlavour.values();
        int index = searchIceCream(item.getFlavour());
        PrintWriter write = new PrintWriter(new FileWriter(file, true));
        if (index == -1) {
            add(item);
            write.append(item.toString() + "\n");
            write.close();
        } else {
            this.remove(this.item);
            this.add(item);
            PrintWriter w = new PrintWriter(this.file);
            for (IceCream i : this) {
                w.println(i.toString());
            }
            w.close();
        }

    }

    /*
    *for searching inside the enum
     */
    public int searchIceCream(IceCreamFlavour flavour) {
        for (IceCream i : this) {
            if (i.flavour.equals(flavour)) {
                this.item = i;
                return indexOf(i);
            }

        }
        return -1;

    }

}
