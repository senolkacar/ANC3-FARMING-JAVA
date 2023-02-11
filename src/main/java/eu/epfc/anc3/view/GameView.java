package eu.epfc.anc3.view;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.vm.GameViewModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameView extends BorderPane {
    private final GameViewModel gameViewModel = new GameViewModel();

    static final int PADDING = 20;
    private static final int SCENE_MIN_WIDTH = 600;
    private static final int SCENE_MIN_HEIGHT = 480;
    static final int FARM_WIDTH = GameFacade.farmWidth();
    static final int FARM_HEIGHT = GameFacade.farmHeight();//

    private final DoubleProperty farmWidthProperty = new SimpleDoubleProperty(500);
    private final DoubleProperty farmHeightProperty = new SimpleDoubleProperty(300);

    private HBox countView;
    private FarmView farmView;
    private HBox menuView;

    public GameView(Stage primaryStage) {
        start(primaryStage);
    }

    public void start(Stage stage) {
        configMainComponents(stage);

        Scene scene = new Scene(this, 600, 480);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Projet ANC3 2223 a02");
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());

        scene.setOnKeyPressed(e -> farmView.onKeyPressed(e.getCode().getChar())); // to pass event to viewModel
    }

    private void configMainComponents(Stage stage) {
        configCount();
        configFarm();
        configMenu();
    }

    private void configCount() {
        countView = new CountView(gameViewModel.getCountViewModel());
        setTop(countView);
    }

    private void configFarm(){
        farmView = new FarmView(gameViewModel.getFarmViewModel(),farmWidthProperty,farmHeightProperty);
        //farmView = new FarmView(gameViewModel.getFarmViewModel(),farmWidthProperty);
        setCenter(farmView);
    }

    private void configMenu() {
        menuView = new MenuView(gameViewModel.getMenuViewModel());
        setBottom(menuView);
    }
}
