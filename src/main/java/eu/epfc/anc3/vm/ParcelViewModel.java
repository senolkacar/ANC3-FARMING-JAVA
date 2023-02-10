package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Position;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ParcelViewModel {

    private final ObjectProperty<Position> position = new SimpleObjectProperty<>();

    public ParcelViewModel(Position position) {
        this.position.set(position);
    }

    public Position getPosition() {
        return position.get();
    }

    public ObjectProperty<Position> positionProperty() {
        return position;
    }

    public void setPosition(Position position) {
        this.position.set(position);
    }


    
}
