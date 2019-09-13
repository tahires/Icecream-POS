/** Name:  Essa Tahir
 * Assignment:  Assignment4
 * Program: PROG24178
 *
 * Making IceCream Inventory
 */
package A5_EssaTahir;

/**
 *
 * @author Essa OG
 */
public class IceCream {

    IceCreamFlavour flavour;
    private double price;
    private int quantity;

    public IceCream() {

    }

    /**
     * @return the flavour
     */

    public IceCreamFlavour getFlavour() {
        return flavour;
    }

    /**
     * @param flavour the flavour to set
     */
    public void setFlavour(IceCreamFlavour flavour) {
        this.flavour = flavour;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        double cost = this.getPrice() * this.getQuantity();
        return cost;
    }

    /*
    * tostring for add to the text.txt
     */
    @Override
    public String toString() {
        return this.flavour.getId() + "|" + this.flavour.getFlavourName() + "|" + this.price + "|" + this.quantity + "|" + this.getCost() + "|";
    }
}
