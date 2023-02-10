package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.view.CountView;
import javafx.beans.property.*;

public class CountViewModel {

    private final GameFacade game;
    private final IntegerProperty countText = new SimpleIntegerProperty(0);

    public CountViewModel(GameFacade game) {
       this.game = game;
    }

    public ReadOnlyIntegerProperty getCountTextProperty() {
        return countText;
    }

}
