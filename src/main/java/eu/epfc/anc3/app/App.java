//ANC3 2223 a02
package eu.epfc.anc3.app;

import eu.epfc.anc3.view.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameView gameView = new GameView(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }

}
