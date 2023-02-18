package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Parcel {

    private final ObjectProperty<Element> value = new SimpleObjectProperty<>(new Element(Type.DIRT,false));//?

    Element getValue() {
        return value.getValue();

    }

    boolean setValue(Element value) {
        this.value.setValue(value);
        return true;
    }

   ObjectProperty<Element> valueProperty() {
        return value;
    }
}
