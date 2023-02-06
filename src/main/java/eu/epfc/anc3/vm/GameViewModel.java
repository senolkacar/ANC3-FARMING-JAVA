package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.view.GameView;
import eu.epfc.anc3.view.MenuView;

public class GameViewModel {

    private final CountViewModel countViewModel;
    private final FarmViewModel farmViewModel;
    private final MenuViewModel menuViewModel;
    private final GameFacade game = new GameFacade();

    public GameViewModel(){
        countViewModel = new CountViewModel(game);
        farmViewModel = new FarmViewModel(game);
        menuViewModel = new MenuViewModel(game);
    }

    public MenuViewModel getMenuViewModes() {
        return menuViewModel;
    }

    public CountViewModel getCountViewMode() {
        return countViewModel;

    }




}
