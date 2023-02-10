package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.Farmer;
import eu.epfc.anc3.model.Position;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class FarmerViewModel {

    private ObjectProperty<Position> position = new SimpleObjectProperty<>();

    public FarmerViewModel() {
        position.set(new Position(0, 0));
    }

    public ObjectProperty<Position> positionProperty() {
        return position;
    }

    public Position getPosition() {
        return position.get();
    }

    public void setPosition(Position position) {
        this.position.set(position);
    }


}
