package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import javafx.scene.input.KeyCode;

import java.util.stream.Stream;


public class GameViewModel {
    private final GameFacade game = new GameFacade();
    private final CountViewModel countViewModel;
    private final FarmViewModel farmViewModel;
    private final MenuViewModel menuViewModel;

    private boolean isPlanting = false;

    public GameViewModel() {
        countViewModel = new CountViewModel(game);
        farmViewModel = new FarmViewModel(game);
        menuViewModel = new MenuViewModel(game);
    }

    public CountViewModel getCountViewModel() {
        return countViewModel;
    }

    public FarmViewModel getFarmViewModel() {
        return farmViewModel;
    }

    public MenuViewModel getMenuViewModel() {
        return menuViewModel;
    }

    public void start() {
        game.start();
    }

    public void reset() {
        game.reset();
    }

    public void onKeyPressed(KeyCode key) {
        if(key == KeyCode.Z || key == KeyCode.UP) {
            game.moveFarmerUp();
        } else if(key == KeyCode.Q || key == KeyCode.LEFT) {
            game.moveFarmerLeft();
        } else if(key == KeyCode.S || key == KeyCode.DOWN) {
            game.moveFarmerDown();
        } else if(key == KeyCode.D || key == KeyCode.RIGHT) {
            game.moveFarmerRight();
        } else if(key == KeyCode.SPACE) {
            isPlanting = true;
            game.plantOrRemove();
        }
    }

    public void onKeyReleased(KeyCode key){
        if (key == KeyCode.SPACE) {
            isPlanting = false;
        }
    }

    public boolean isPlanting() {
        return isPlanting;
    }

    public void continuePlantingOrRemoving() {
        game.plantOrRemove();
    }


}
