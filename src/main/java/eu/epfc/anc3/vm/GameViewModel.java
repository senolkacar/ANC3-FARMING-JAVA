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

    public void reset() {
        game.reset();
    }

    public void onKeyPressed(String character) {
        if ("Z".equalsIgnoreCase(character)) {
            farmViewModel.moveFarmerUp();
        } else if ("Q".equalsIgnoreCase(character)) {
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
