package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import javafx.beans.property.ReadOnlyIntegerProperty;

public class CountViewModel {
    private final GameFacade game;

    public CountViewModel(GameFacade game) {
        this.game = game;
    }

    public ReadOnlyIntegerProperty valueProperty() {
        return game.getGrassParcelCountValueProperty();
    }

    public ReadOnlyIntegerProperty dayProperty() {
        return game.getDayProperty();
    }
}
