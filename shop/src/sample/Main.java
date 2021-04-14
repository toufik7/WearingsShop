package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import static sample.methodes.filter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        GUI gui = new GUI(primaryStage);
        filter();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
