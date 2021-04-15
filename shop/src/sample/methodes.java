package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import sample.Services.ServiceAdapter;
import sample.Wearings.Wearings;
import static sample.Facade.JfxHelper.*;
import static sample.Services.Accdb.*;

public class methodes {
    private static ComboBox<String> ibrand;
    private static ComboBox<String> ipricemin;
    private static ComboBox<String> ipricemax ;
    private static ComboBox<String> igender ;
    private static ComboBox<String> isize;
    private static ComboBox<String> icolor;
    private static Button search;
    private static TableView<Wearings> inventory;
    private static Label nbProd;
    private static int np =0;
    public static String user = "pc cam";
    private static TableColumn<Wearings, Integer> product;
    private static TableColumn<Wearings, Integer> brand;
    private static TableColumn<Wearings, Integer> gender;
    private static TableColumn<Wearings, Integer> size;
    private static TableColumn<Wearings, Integer> color;
    private static TableColumn<Wearings, Integer> price;

    public static GridPane filters(){
        ServiceAdapter sa = new ServiceAdapter();

        GridPane gridPane = makeGP(8,20);

        //filters_Label
        Label filters = makeLabel("Filtrers");
        gridPane.add(filters, 0, 1);

        //marque_Label-------------------------------------------------------------------------------
        Label brand = makeLabel("Brand");
        //mark_input
        ibrand = makeCB("...",false);
        putFilter(gridPane,brand,ibrand,1,2);
        ibrand.getItems().add("...");
        sa.GetBrand(ibrand); // get brands from ms access
        ibrand.getItems().add("Adidas");
        ibrand.getItems().add("Nike");
        ibrand.getItems().add("Umbro");
        ibrand.getItems().add("Puma");


        //Price_Label-------------------------------------------------------------------------------
        Label price_min = makeLabel("Price Min");
        Label price_max = makeLabel("Price Max");
        //price_input
        ipricemin = makeCB("...",false);
        ipricemax = makeCB("...",false);
        putFilter(gridPane,price_min,ipricemin,2,2);
        putFilter(gridPane,price_max,ipricemax,3,2);
        ipricemin.getItems().add("...");
        ipricemax.getItems().add("...");
        ipricemax.getItems().add("120");
        ipricemax.getItems().add("100");
        ipricemax.getItems().add("80");
        ipricemin.getItems().add("50");
        ipricemin.getItems().add("30");
        ipricemin.getItems().add("10");



        //Gender_Label----------------------------------------------------------------------------
        Label gender = makeLabel("Gender");
        //gender_input
        igender = makeCB("...",false);
        putFilter(gridPane,gender,igender,4,2);
        igender.getItems().add("...");
        sa.GetGender(igender); // get brands from ms access

        //Color_Label----------------------------------------------------------------------------
        Label color = makeLabel("Color");
        //color_input
        icolor = makeCB("...",false);
        putFilter(gridPane,color,icolor,5,2);
        icolor.getItems().add("...");
        sa.GetColor(icolor); // get color from ms access
        icolor.getItems().add("Green");
        icolor.getItems().add("White");
        icolor.getItems().add("Red");
        icolor.getItems().add("Orange");


        //Size_Label----------------------------------------------------------------------------
        Label size = makeLabel("Size");
        //size_input
        isize = makeCB("...",false);
        putFilter(gridPane,size,isize,6,2);
        isize.getItems().add("...");
        sa.GetSize(isize); // get size from ms access
        isize.getItems().add("S");
        isize.getItems().add("M");
        isize.getItems().add("L");
        isize.getItems().add("XL");

        //button search----------------------------------------------------------------------------
        search = putButton(gridPane,"Search",0,3);
        //nb products------------------------------------------------------------------------------
        nbProd = putLabel(gridPane,"",1,3);

        return gridPane;
    }
    public static TableView table(){
        inventory = new TableView<>();
        /**********************************************************************************************/
        //create colomns
        product = makecolomn("Product","product",300);
        brand = makecolomn("Brand","mark",50);
        gender = makecolomn("Gender","gender",50);
        size = makecolomn("Size","size",50);
        color = makecolomn("Color","color",50);
        price = makecolomn("Price","price",50);

        // add colomns to table view
        inventory.getColumns().addAll(
                product,brand,gender,size,color,price
        );
        // populate table view when pressing button
    return inventory;

    }

    public static void filter(){
        Search s = new Search();
        s.anySearch();

        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                s.removeAllFilters();
                if (!ibrand.getValue().equals("...")) {
                    s.addFilter("mark", ibrand.getValue());
                }
                if (!igender.getValue().equals("...")) {
                    s.addFilter("gender", igender.getValue());
                }
                if (!icolor.getValue().equals("...")) {
                    s.addFilter("color", icolor.getValue());
                }
                if (!isize.getValue().equals("...")) {
                    s.addFilter("size", isize.getValue());
                }
                if (!(ipricemax.getValue().equals("...") || ipricemin.getValue().equals("..."))) {

                    s.addPriceFilter(Double.valueOf(ipricemin.getValue()), Double.valueOf(ipricemax.getValue()));
                }
                inventory.getItems().clear();
                inventory.getItems().addAll(s.getResult());
                np= inventory.getItems().size();
                nbProd.setText(np + " Products Found");
                //System.out.println(s.toString());
            }
        });
    }
}
