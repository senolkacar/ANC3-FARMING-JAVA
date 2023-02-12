package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.ParcelValue;
import javafx.beans.property.ReadOnlyObjectProperty;

public class CountViewModel {
    private final GameFacade game;

    public CountViewModel(GameFacade game) {
        this.game = game;
    }

    public ReadOnlyObjectProperty<Integer> valueProperty() {
        return game.getGrassParcelCountValueProperty();
    }
}
