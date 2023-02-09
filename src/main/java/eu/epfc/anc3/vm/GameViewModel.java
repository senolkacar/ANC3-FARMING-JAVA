package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import javafx.beans.property.ReadOnlyBooleanProperty;

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

    public MenuViewModel getMenuViewModel() {
        return menuViewModel;
    }

    public CountViewModel getCountViewModel() {
        return countViewModel;
    }

    public FarmViewModel getFarmViewModel(){
        return farmViewModel;
    }

    public ReadOnlyBooleanProperty isGameStartedProperty() {
        return game.isStartedProperty();
    }



}
