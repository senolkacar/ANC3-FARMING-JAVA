package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.GameViewModel;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameView extends BorderPane {
    private final GameViewModel gameViewModel = new GameViewModel();

    static final int PADDING = 20;
    private static final int SCENE_MIN_WIDTH = 600;
    private static final int SCENE_MIN_HEIGHT = 480;
    //static final int GRID_WIDTH = GameFacade.gridWidth();

    private HBox countView;
//    private GridPane farmView;
    private HBox menuView;
    public GameView(Stage primaryStage) {
        start(primaryStage);
    }

    public void start(Stage stage) {
        configMainComponents(stage);

        Scene scene = new Scene(this, 640, 480);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Projet ANC3 2223 a02");
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
    }

    private void configMainComponents(Stage stage) {
        configCount();
//        configFarm();
        configMenu();
    }

    private void configMenu() {
        menuView = new MenuView(gameViewModel.getMenuViewModes());
        setBottom(menuView);
    }

    private void configCount() {
        countView = new CountView(gameViewModel.getCountViewMode());
        setTop(countView);


    }


}
