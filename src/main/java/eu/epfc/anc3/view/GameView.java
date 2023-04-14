package eu.epfc.anc3.view;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.vm.GameViewModel;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameView extends BorderPane {
    private final GameViewModel gameVM;
    private final CountView countView;
    private final FarmView farmView;
    private final MenuView menuView;
    private final MenuRightView menuRightView;

    static final int FARM_WIDTH = GameFacade.getFarmWidth();
    static final int FARM_HEIGHT = GameFacade.getFarmHeight();
    static final int PADDING = GameFacade.getPadding();

    public GameView(Stage stage) {
        gameVM = new GameViewModel();

        countView = new CountView(gameVM.getCountViewModel());
        countView.setAlignment(Pos.CENTER);
        super.setTop(countView);
        farmView = new FarmView(gameVM.getFarmViewModel());
        farmView.setAlignment(Pos.CENTER);
        super.setCenter(farmView);
        menuView = new MenuView(gameVM.getMenuViewModel());
        menuView.setAlignment(Pos.CENTER);
        super.setBottom(menuView);
        menuView.setFocusTraversable(true);

        menuRightView = new MenuRightView(gameVM.getMenuRightViewModel());
        menuRightView.setAlignment(Pos.CENTER);
        super.setRight(menuRightView);
        menuRightView.setFocusTraversable(true);

        Scene scene = new Scene(this, 1200, 700);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Projet ANC3 2223 a02");
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        scene.setOnKeyPressed(e -> gameVM.onKeyPressed(e.getCode()));
        scene.setOnKeyReleased(e -> gameVM.onKeyReleased(e.getCode()));
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                    if (gameVM.isPlanting()) {
                        gameVM.continuePlantingOrRemoving();
                    }
            }
        };
        timer.start();
        gameVM.start();
    }
}
