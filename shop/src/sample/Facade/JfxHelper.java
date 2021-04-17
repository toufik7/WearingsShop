package sample.Facade;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.AlertBox;
import sample.Wearings.Wearings;

public class JfxHelper {

    public static Stage makeWindow(Stage primaryStage){

        Stage window = primaryStage;

        window.setOnCloseRequest(event -> {
            event.consume();
            // Platform.exit();
            System.exit(0);

            //closeProgram();
        });

        window.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {

            switch(event.getCode().getCode()) {
                case 27 : { // 27 = ESC key
                    System.exit(0);
                    break;
                }
                default:  {
                    System.out.println("Unrecognized key");
                }
            }
        });
        return window;
    }
    public static void istart(Stage window,Scene scene){
        window.setScene(scene);
        window.setTitle("SHOP");
        window.show();
    }
    public static Scene makeSeane(VBox layout,String css){
        Scene scene = new Scene(layout, 1100, 650);
        scene.getStylesheets().add(css);
        return scene;
    }
    public static Scene makeSeane(VBox layout){
        Scene scene = new Scene(layout, 950, 650);
        return scene;
    }
    public static Label makeLabel(String txt){
        Label label = new Label();
        label.setText(txt);
        return label;
    }
    public static Button makeInventoryBtn(Stage window, Scene scean2){
        Button inventory = new Button();
        inventory.setCursor(Cursor.HAND);
        inventory.setText("Inventory");
        inventory.setOnAction(e -> window.setScene(scean2));
        return inventory;
    }
    public static Button makeCreatebtn(Stage window, Scene scean){
        Button crt = new Button();
        crt.setCursor(Cursor.HAND);
        crt.setText("Create");
        crt.setOnAction(e -> window.setScene(scean));
        return crt;
    }
    public static Button makeHelpbtn(String css){
        Button help = new Button();
        help.setCursor(Cursor.HAND);
        help.setText("Help");
        help.setOnAction(e -> AlertBox.display("Help","En Réalisation ..."));
        return help;
    }
    public static ToolBar makeToolBar(/*Button crt,*/Button inventory,Button help){
        ToolBar toolbar = new ToolBar();
        //toolbar.getItems().add(crt);
        toolbar.getItems().add(inventory);
        toolbar.getItems().add(help);
        return toolbar;
    }
    public static BorderPane makeBorderPane(ToolBar toolbar){
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(toolbar);
        return borderPane;
    }
    public static VBox makeLayout(BorderPane borderPane,Label label1){
        VBox layout = new VBox(20);
        layout.getChildren().addAll(borderPane,label1);
        return layout;
    }
    public static VBox makeLayout(BorderPane borderPane, Label label1, GridPane filters, TableView table){
        VBox layout = new VBox(20);
        layout.getChildren().addAll(borderPane,label1,filters,table);
        return layout;
    }
    public static GridPane makeGP(int v,int h){
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setVgap(v);
        gp.setHgap(h);
        return gp;
    }
    public static ComboBox<String> makeCB(String txt, boolean enable){
        ComboBox<String> cb = new ComboBox<>();
        cb.setValue(txt);
        cb.setEditable(enable);
        return cb;
    }
    public static ComboBox<String> makeCBp(String v, boolean enable){
        ComboBox<String> cb = new ComboBox<>();
        cb.setValue(v);
        cb.setEditable(enable);
        cb.getItems().add("10");
        cb.getItems().add("50");
        cb.getItems().add("100");
        cb.getItems().add("150");
        cb.getItems().add("200");
        cb.setMaxWidth(70);
        return cb;
    }
    public static void putFilter(GridPane gridPane,Label l,ComboBox<String> cb,int col, int row){
        HBox lcb = new HBox(10);
        lcb.getChildren().addAll(l, cb);
        gridPane.add(lcb, col, row);
    }
    public static Button putButton(GridPane gp,String txt,int col, int row){
         Button btn = new Button(txt);
         btn.setMinWidth(100);
         gp.add(btn,col,row);
         return btn;
    }
    public static Label putLabel(GridPane gp,String txt,int col, int row){
        Label l = new Label(txt);
        l.setWrapText(true);
        gp.add(l,col,row);
        return l;
    }
    public static TableColumn<Wearings, Integer> makecolomn(String title,String property,int width){
        TableColumn<Wearings, Integer> cell = new TableColumn<>(title);
        cell.setMinWidth(width);
        cell.setCellValueFactory(new PropertyValueFactory<>(property));
        return cell;
    }
}
