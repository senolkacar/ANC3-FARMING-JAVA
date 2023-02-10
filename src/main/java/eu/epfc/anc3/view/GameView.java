package eu.epfc.anc3.view;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.vm.GameViewModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameView extends BorderPane {
    private final GameViewModel gameViewModel = new GameViewModel();

    static final int PADDING = 25;
    private static final int SCENE_MIN_WIDTH = 900;
    private static final int SCENE_MIN_HEIGHT = 700;

    static final int FARM_WIDTH = GameFacade.farmWidth();
    static final int FARM_HEIGHT = GameFacade.farmHeight();

    private FarmView farmView;
    private CountView countView;
    private ButtonView buttonView;

    private final DoubleProperty farmWidthProperty = new SimpleDoubleProperty(400);

    public GameView(Stage primaryStage){
        start(primaryStage);
    }

    public void start(Stage stage){
        configMainComponents();
        Scene scene = new Scene(this, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);
        stage.setScene(scene);
        stage.show();
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
        stage.setResizable(false);
        farmView.requestFocus();
    }

    private void configMainComponents(){
        configCountView();
        configFarmView();
        configButtonView();

    }

    private void configCountView(){
        countView = new CountView(gameViewModel.getCountViewModel());
        VBox countBox = new VBox(countView);
        countBox.setAlignment(Pos.TOP_CENTER);
        countView.setAlignment(Pos.CENTER);
        setTop(countBox);
    }

    private void configFarmView(){
        createFarm();
    }

    private void configButtonView(){
        buttonView = new ButtonView(gameViewModel.getButtonViewModel());
        VBox buttonBox = new VBox(buttonView);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonView.setAlignment(Pos.CENTER);
        setBottom(buttonBox);
    }

    private void createFarm(){
        farmView = new FarmView(gameViewModel.getFarmViewModel(),gameViewModel.getFarmerViewModel(), farmWidthProperty);
        setCenter(farmView);
    }
}
