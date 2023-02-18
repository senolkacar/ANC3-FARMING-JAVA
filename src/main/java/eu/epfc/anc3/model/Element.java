package eu.epfc.anc3.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.ImageView;

public class Element  {
    private final ObjectProperty<Type> type = new SimpleObjectProperty<>();
    private final BooleanProperty isFarmerOnParcel = new SimpleBooleanProperty();

    public Element(Type type, boolean isFarmerOnParcel) {
        setType(type);
        setFarmerOnParcel(isFarmerOnParcel);
    }

    public Type getType() {
        return type.get();
    }

    public void setType(Type type) {
        this.type.set(type);
    }

    public boolean isFarmerOnParcel() {
        return isFarmerOnParcel.get();
    }

    public void setFarmerOnParcel(boolean isFarmerOnParcel) {
        this.isFarmerOnParcel.set(isFarmerOnParcel);
    }

    public BooleanProperty isFarmerOnParcelProperty() {
        return isFarmerOnParcel;
    }

    public ObjectProperty<Type> typeProperty() {
        return type;
    }
}
