package eu.epfc.anc3.model;

import eu.epfc.anc3.view.ParcelView;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Parcel {

    private final ObjectProperty<ParcelValue> value = new SimpleObjectProperty<>(ParcelValue.DIRT);

    ParcelValue getValue(){
        return value.getValue();
    }

    boolean setValue(ParcelValue value) {
        //if farmer doesn't exist return false
        this.value.setValue(value);
        return true;
    }

    ReadOnlyObjectProperty<ParcelValue> valueProperty() {
        return value;
    }


}
