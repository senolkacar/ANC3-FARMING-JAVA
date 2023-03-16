package eu.epfc.anc3.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

class Day {

    private IntegerProperty dayProperty = new SimpleIntegerProperty(1);

    int getDayProperty() {
        return dayProperty.get();
    }

    IntegerProperty dayPropertyProperty() {
        return dayProperty;
    }

    void resetDayProperty() {
        this.dayProperty.set(1);
    }

    void increaseDayProperty() {
        dayProperty.set(dayProperty.get()+1);
    }


}
