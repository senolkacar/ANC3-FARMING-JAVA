package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Parcel {
    private final ObjectProperty<Type> value = new SimpleObjectProperty<>(Type.DIRT);
    Type getValue() {
        return value.get();
    }

    public ObjectProperty<Type> valueProperty() {
        return value;
    }
}
