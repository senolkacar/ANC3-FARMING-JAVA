package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;

import java.util.Arrays;
import java.util.stream.Stream;

public class GameViewModel {
    private final GameFacade game = new GameFacade();
    private final CountViewModel countViewModel;
    private final FarmViewModel farmViewModel;
    private final MenuViewModel menuViewModel;

    private boolean spaceBarPressed = false;

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

    public void onKeyPressed(String character) {
        if (Stream.of("W", "Z").anyMatch(s -> s.equalsIgnoreCase(character))) {
            game.moveFarmerUp();
        } else if (Stream.of("A", "Q").anyMatch(s -> s.equalsIgnoreCase(character))) {
            game.moveFarmerLeft();
        } else if ("S".equalsIgnoreCase(character)) {
            game.moveFarmerDown();
        } else if ("D".equalsIgnoreCase(character)) {
            game.moveFarmerRight();
        } else if (" ".equals(character)) {
            game.plantOrRemoveGrass();
        }
    }
}
