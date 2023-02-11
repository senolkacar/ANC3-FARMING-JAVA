package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.ImageView;

public abstract class Elements extends ImageView {

    private ObjectProperty<Type> typeProperty = new SimpleObjectProperty<>();

    public Elements(Type type) {
        typeProperty.set(type);
    }

    public ObjectProperty<Type> typeProperty() {
        return typeProperty;
    }
}
