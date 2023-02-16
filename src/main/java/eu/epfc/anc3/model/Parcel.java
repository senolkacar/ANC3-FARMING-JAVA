package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

class Parcel {

    private final ObjectProperty<ElementValue> value = new SimpleObjectProperty<>(ElementValue.DIRT);//?

    ElementValue getValue() {
        return value.getValue();

    }

    boolean setValue(ElementValue value) {
        this.value.setValue(value);
        return true;
    }

   ObjectProperty<ElementValue> valueProperty() {
        return value;
    }
}
