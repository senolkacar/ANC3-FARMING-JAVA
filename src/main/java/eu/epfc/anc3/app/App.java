//ANC3 2223 a02
package eu.epfc.anc3.app;

import eu.epfc.anc3.view.GameView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        new GameView(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}
