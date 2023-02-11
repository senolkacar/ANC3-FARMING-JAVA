package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import javafx.beans.property.ReadOnlyBooleanProperty;

public class GameViewModel {

    private final CountViewModel countViewModel;
    private final FarmViewModel farmViewModel;
    private final MenuViewModel menuViewModel;
    private final GameFacade gameFacade = new GameFacade();

    public GameViewModel(){
        gameFacade.start();
        countViewModel = new CountViewModel(gameFacade);
        farmViewModel = new FarmViewModel(gameFacade);
        menuViewModel = new MenuViewModel(gameFacade);
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
        return gameFacade.isStartedProperty();
    }



}
