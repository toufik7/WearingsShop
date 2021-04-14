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
    GUI(Stage primaryStage){

        Label label1 = makeLabel("Add new Products Here ! -------------------");
        Label label2 = makeLabel("Your Inventory Is Here ------------------");

        window = makeWindow(primaryStage);

        //creation peage
        Button inventory = makeInventoryBtn(window, scene2);
        Button crt = makerCreatebtn(window,scene);
        Button help = makeHelpbtn();
        ToolBar toolbar = makeToolBar(crt,inventory,help);
        BorderPane borderPane = makeBorderPane(toolbar);
        layout = makeLayout(borderPane,label1);
        scene = makeSeane(layout);

        // inventory page
        Button inventory2 = makeInventoryBtn(window, scene2);
        Button crt2 = makerCreatebtn(window,scene);
        Button help2 = makeHelpbtn();
        ToolBar toolbar2 = makeToolBar(crt2,inventory2,help2);
        BorderPane borderPane2 = makeBorderPane(toolbar2);
        layout2 = makeLayout(borderPane2,label2,filters(),table());
        scene2 = makeSeane(layout2);

        istart(window,scene2);
    }
}
