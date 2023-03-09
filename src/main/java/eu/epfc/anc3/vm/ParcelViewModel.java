package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.*;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ParcelViewModel {
    private final Position position;
    private final GameFacade game;
    private ObjectProperty<CarrotState> state = new SimpleObjectProperty<>(new CarrotState1());//public ?
    ListProperty<Element> valueProperty;

    public ParcelViewModel(Position position, GameFacade game) {
        this.position = position;
        this.game = game;
        valueProperty = game.getParcelValueProperty(position);
        if (containsCarrot(position))
            state.set(new CarrotState1());

    }

    boolean containsCarrot(Position position) {
       return game.containsCarrot( position);
    }

    public ListProperty<Element> valueProperty() {
        return game.getParcelValueProperty(position);
    }

    public void onMouseClicked(){
        game.onMouseClicked(position);
    }
}
