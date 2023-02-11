package eu.epfc.anc3.vm;



import eu.epfc.anc3.model.Position;
import eu.epfc.anc3.model.Type;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ParcelViewModel {

    private final ObjectProperty<Position> position;
    private ObjectProperty<Type> type = new SimpleObjectProperty<>(Type.DIRT);

    public ParcelViewModel(Position position) {
        this.position = new SimpleObjectProperty<>(position);
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

    public ObjectProperty<Type> typeProperty() {
        return type;
    }




    
}
