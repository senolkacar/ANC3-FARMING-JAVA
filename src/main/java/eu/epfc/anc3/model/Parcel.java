package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Parcel {

    private final ObjectProperty<ParcelValue> value = new SimpleObjectProperty<>(ParcelValue.DIRT);

    ParcelValue getValue() {
        return value.getValue();
    }

    boolean setValue(ParcelValue value) {
        this.value.setValue(value);
        return true;
    }

   ObjectProperty<ParcelValue> valueProperty() {
        return value;
    }
}
