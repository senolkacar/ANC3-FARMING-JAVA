package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.*;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

public class ParcelViewModel {
    private final Position position;
    private final GameFacade game;


//    private ObjectProperty<CarrotState> state = new SimpleObjectProperty<>(new CarrotState1());//public ?
//    ListProperty<Element> valueProperty;


    public ParcelViewModel(Position position, GameFacade game) {
        this.position = position;
        this.game = game;
    }

    boolean containsCarrot(Position position) {
       return game.containsCarrot( position);
    }

    public ListProperty<Element> valueProperty() {
        return game.getParcelValueProperty(position);
    }

    public ObjectProperty<ImageType> imageTypeObjectPropertyProperty() {
        return game.imageTypeObjectPropertyProperty(position);
    }

    public void onMouseClicked(){
        game.onMouseClicked(position);
    }

    public void removeElement(ElementType elementType) {
        game.removeElement(position, elementType);
    }


}
