package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.Element;
import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Position;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;

public class ParcelViewModel {
    private final Position position;
    private final GameFacade game;

    public ParcelViewModel(Position position, GameFacade game) {
        this.position = position;
        this.game = game;
    }

    public ListProperty<Element> valueProperty() {
        return game.getParcelValueProperty(position);
    }

    public void onMouseClicked(){
        game.onMouseClicked(position);
    }
    
}
