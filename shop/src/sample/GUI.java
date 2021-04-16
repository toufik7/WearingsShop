package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static sample.Facade.JfxHelper.*;
import static sample.methodes.filters;
import static sample.methodes.table;

public class GUI {
    private VBox layout,layout2;
    private Stage window; private Scene scene,scene2;
    public static String css;
    GUI(Stage primaryStage){

        Label label1 = makeLabel("Add new Products Here ! -------------------");
        Label label2 = makeLabel("Your Inventory Is Here ------------------");
        css = this.getClass().getResource("index.css").toExternalForm();


        window = makeWindow(primaryStage);

        //creation peage
        Button inventory = makeInventoryBtn(window, scene2);
        Button crt = makeCreatebtn(window,scene);
        Button help = makeHelpbtn(css);
        ToolBar toolbar = makeToolBar(crt,inventory,help);
        BorderPane borderPane = makeBorderPane(toolbar);
        layout = makeLayout(borderPane,label1);
        scene = makeSeane(layout,css);

        // inventory page
        Button inventory2 = makeInventoryBtn(window, scene2);
        Button crt2 = makeCreatebtn(window,scene);
        Button help2 = makeHelpbtn(css);
        ToolBar toolbar2 = makeToolBar(inventory2,crt2,help2);
        BorderPane borderPane2 = makeBorderPane(toolbar2);
        layout2 = makeLayout(borderPane2,label2,filters(),table());
        scene2 = makeSeane(layout2,css);

        istart(window,scene2);
    }
}
