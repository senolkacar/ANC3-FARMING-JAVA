package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Parcel {

    private final ObjectProperty<ParcelValue> value = new SimpleObjectProperty<>(ParcelValue.DIRT);

    ReadOnlyObjectProperty<ParcelValue> valueProperty() {
        return value;
    }

}
