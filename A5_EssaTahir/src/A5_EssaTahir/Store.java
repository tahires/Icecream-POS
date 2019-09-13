/** Name:  Essa Tahir
 * Assignment:  Assignment5
 * Program: PROG24178
 *
 * Making a Icecream Inventory
 */
package A5_EssaTahir;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import proj24178.utils.Validator;

/**
 *
 * @author Essa OG
 */
public class Store extends Application {

    /*
    label variable for text,price and quantity
     */
    private Label lblText;
    private Label lblPrice, lblQuantity;
    /*
    *for text field for price and quantity
     */

    private TextField txtPrice, txtQuantity;

    /*
    *The textarea for the display
     */
    private TextArea txaDisplay;

    /*
    *flavour for the combobox
     */
    private ComboBox cboFlavour;

    //private String[] strFlavour;
    /*
    buttons for reset, save and show inventory
     */
    private Button btnReset, btnSave, btnAdd;

    /*
    for the menubar
     */
    private MenuBar menuBar;
    private MenuItem exitItem;
    private Menu fileMenu;

    /*
    calling the icecream list
     */
    private IceCreamList list;

    /*
    *layout of the gui
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

        /*
        *BorderPane for the root
         */
        BorderPane root = new BorderPane();
        list = new IceCreamList();

        /*
        gridpane for label and textarea and combocbox
         */
        GridPane pnlInfo = new GridPane();
        pnlInfo.setVgap(10);
        pnlInfo.getStyleClass().add("grid-pane");
        (this.lblText = new Label("Ice Cream Inventory")).setId("title");
        lblPrice = new Label("Price: ");
        lblQuantity = new Label("Quantity: ");
        txtPrice = new TextField();
        txtQuantity = new TextField();
        pnlInfo.setGridLinesVisible(false);
        pnlInfo.add(lblText, 0, 0);
        GridPane.setColumnSpan(lblText, 2);

        cboFlavour = new ComboBox();
        pnlInfo.add(cboFlavour, 1, 1);
        IceCreamFlavour[] flavour = IceCreamFlavour.values();
        ObservableList<IceCreamFlavour> flavours = FXCollections.observableArrayList(flavour);
        cboFlavour.getItems().addAll(flavours);
        cboFlavour.setValue("Select Flavour");
        GridPane.setColumnSpan(cboFlavour, 2);
        pnlInfo.add(lblPrice, 0, 3);
        pnlInfo.add(this.txtPrice, 1, 3);
        pnlInfo.add(lblQuantity, 0, 4);
        pnlInfo.add(this.txtQuantity, 1, 4);
//        pnlInfo.setGridLinesVisible(true);
        pnlInfo.setAlignment(Pos.CENTER);

//        pnlInfo.setAlignment(Pos.CENTER);
//        pnlInfo.setPadding(new Insets(10,10,10,10));
//        pnlInfo.addRow(1, lblPrice,txtPrice);
//        pnlInfo.addRow(2,lblQuantity,txtQuantity);
//        StackPane pnlFlavour = new StackPane();
//        pnlFlavour.setPadding(new Insets(10,10,10,10));
        //strFlavour  = new String[]{"Select a Flavour","VANILLA","CHOCOLATE","STAWBERRY","BUTTER_PECAN","MOOSE","RASPBERRY"};
//        pnlFlavour.setAlignment(Pos.CENTER);
//        pnlFlavour.getChildren().add(cboFlavour);

        /*
vbox to show the inventory
         */
        VBox pnlDisplay = new VBox(15);
        (txaDisplay = new TextArea()).setMaxWidth(360);
        pnlDisplay.setSpacing(20);
        pnlDisplay.getChildren().addAll(pnlInfo, txaDisplay);
        pnlDisplay.setAlignment(Pos.CENTER);
        /*
        hbox for the buttons
         */

        HBox pnlButtons = new HBox(15);
        pnlButtons.setPadding(new Insets(15));
        pnlButtons.setAlignment(Pos.CENTER);
        btnReset = new Button("_Reset");
        btnReset.setPrefWidth(60);
        btnReset.setOnAction(e -> {
            try {
                getButtonClicked(e);
            } catch (Exception ex) {
                Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btnSave = new Button("_Save");
        btnSave.setPrefWidth(60);
        btnSave.setOnAction(e -> {
            try {
                getButtonClicked(e);
            } catch (Exception ex) {
                Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btnAdd = new Button("Show _Inventory");
        btnAdd.setPrefWidth(120);
        btnAdd.setOnAction(e -> {
            try {
                getButtonClicked(e);
            } catch (Exception ex) {
                Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btnReset.setMnemonicParsing(true);
        btnSave.setMnemonicParsing(true);
        btnAdd.setMnemonicParsing(true);
        pnlButtons.getChildren().addAll(btnReset, btnSave, btnAdd);

        /*
        *for the menu bar
         */
        this.menuBar = new MenuBar();
        this.fileMenu = new Menu("_File");
        this.menuBar.getMenus().add(fileMenu);
        this.exitItem = new MenuItem("E_xit");
        exitItem.setAccelerator(new KeyCodeCombination(KeyCode.E,
                KeyCombination.SHORTCUT_DOWN));
        fileMenu.getItems().add(exitItem);

        exitItem.setOnAction(e -> {
            try {
                getButtonClicked(e);
            } catch (Exception ex) {
                Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        root.setTop(menuBar);

        root.setCenter(pnlDisplay);
        root.setBottom(pnlButtons);

        Scene scene = new Scene(root, 450, 500);
        root.getStylesheets().add("style.css");

        primaryStage.setTitle("Assignment 5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /*
    Method to show the inventory
     */
    public void inventory() {

        String top = String.format("%-3s%-16s%-9s%-5s%-8s\n", "ID", "Flavour", "Price", "Qty", "Cost");
        top += "=======================================\n";
        this.txaDisplay.setText(top);
        for (IceCream item : this.list) {
            this.txaDisplay.appendText(String.format("%-3d%-16s%4.2f%7d%9.2f\n", item.getFlavour().getId(), item.getFlavour().getFlavourName(), item.getPrice(), item.getQuantity(), item.getCost()));
        }
    }

    /*
    *action event for the button to show IceCream Inventory 
     */
    public void getButtonClicked(ActionEvent e) throws IOException, Exception {
        /*
        *to exit the gui
         */
        if (e.getSource() == this.exitItem) {
            System.exit(0);

        }
        /*
        *to reset the gui
         */

        if (e.getSource() == this.btnReset) {
            this.cboFlavour.setValue("Select a Flavour");
            this.txtPrice.clear();
            this.txtQuantity.clear();
            this.txaDisplay.clear();
            this.lblPrice.getStyleClass().remove("error");

            this.lblQuantity.getStyleClass().remove("error");
        }

        /*
        *to save the data
         */
        if (e.getSource() == this.btnSave) {

            int index = this.cboFlavour.getSelectionModel().getSelectedIndex();
            if (index == -1) {
                this.txaDisplay.setText("Select a Flavour");
                return;
            }
            IceCreamFlavour[] flavour = IceCreamFlavour.values();
            IceCream iceCream = new IceCream();
            iceCream.setFlavour(flavour[index]);

            Validator valid = new Validator();

            if (!valid.isValidDouble(this.txtPrice.getText())) {
                this.txaDisplay.setText("Invalid price");
                if (!this.lblPrice.getStyleClass().contains("error")) {
                    this.lblPrice.getStyleClass().add("error");

                } else {
                    this.lblPrice.getStyleClass().remove("error");
                }
                return;
            }
            double price = Double.parseDouble(this.txtPrice.getText());
            iceCream.setPrice(price);

            if (valid.isValidInteger(this.txtQuantity.getText())) {
                int quantity = Integer.parseInt(this.txtQuantity.getText());
                iceCream.setQuantity(quantity);
                this.lblQuantity.getStyleClass().remove("error");
                try {
                    this.list.writeRecord(iceCream);
                    this.inventory();
                } catch (IOException ex) {
                    this.txaDisplay.setText(ex.getMessage());
                }
                return;
            }
            this.txaDisplay.setText("Invalid quantity...");
            if (!this.lblQuantity.getStyleClass().contains("error")) {
                this.lblQuantity.getStyleClass().add("error");
            }
        }

        /*
        *to show the inventory
         */
        if (e.getSource() == this.btnAdd) {
            String top = String.format("%-3s%-16s%-9s%-5s%-8s\n", "ID", "Flavour", "Price", "Qty", "Cost");
            top += "=======================================\n";
            this.txaDisplay.setText(top);
            for (IceCream item : this.list) {
                this.txaDisplay.appendText(String.format("%-3d%-16s%4.2f%7d%9.2f\n", item.getFlavour().getId(), item.getFlavour().getFlavourName(), item.getPrice(), item.getQuantity(), item.getCost()));
            }

        }
    }

}
