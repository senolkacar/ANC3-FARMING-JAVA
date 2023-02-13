package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;

public class GameViewModel {
    private final GameFacade game = new GameFacade();
    private final CountViewModel countViewModel;
    private final FarmViewModel farmViewModel;
    private final MenuViewModel menuViewModel;

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
        if ("W".equalsIgnoreCase(character)) {
            farmViewModel.moveFarmerUp();//game model gere le logique du jeu
        } else if ("A".equalsIgnoreCase(character)) {
            farmViewModel.moverFarmerLeft();
        } else if ("S".equalsIgnoreCase(character)) {
            farmViewModel.moveFarmerDown();
        } else if ("D".equalsIgnoreCase(character)) {
            farmViewModel.moveFarmerRight();
        } else if (" ".equals(character)) {
            farmViewModel.plantOrRemoveGrass();
        }
    }
}
