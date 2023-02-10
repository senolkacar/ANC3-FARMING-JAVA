package eu.epfc.anc3.vm;


import eu.epfc.anc3.model.Farmer;
import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Position;
import javafx.beans.property.ReadOnlyBooleanProperty;

public class GameViewModel {
    private final FarmViewModel farmViewModel;
    private final CountViewModel countViewModel;
    private final ButtonViewModel buttonViewModel;
    private final FarmerViewModel farmerViewModel;

    private final GameFacade game = new GameFacade();


    public GameViewModel() {
        farmViewModel = new FarmViewModel(game);
        countViewModel = new CountViewModel(game);
        buttonViewModel = new ButtonViewModel(game);
        farmerViewModel = new FarmerViewModel();
    }

    public FarmViewModel getFarmViewModel() {
        return farmViewModel;
    }
    public CountViewModel getCountViewModel() {
        return countViewModel;
    }
    public ButtonViewModel getButtonViewModel() {
        return buttonViewModel;
    }
    public FarmerViewModel getFarmerViewModel() {
        return farmerViewModel;
    }

    public ReadOnlyBooleanProperty isGameStartedProperty() {
        return game.isStartedProperty();
    }

}
