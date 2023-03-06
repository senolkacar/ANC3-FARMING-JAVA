package eu.epfc.anc3.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

class Day {

    private IntegerProperty dayProperty = new SimpleIntegerProperty(0);

    public int getDayProperty() {
        return dayProperty.get();
    }

    public IntegerProperty dayPropertyProperty() {
        return dayProperty;
    }

    public void setDayProperty(int dayProperty) {
        this.dayProperty.set(dayProperty);
    }

    void increaseDayProperty() {
        dayProperty.set(dayProperty.get()+1);        
    }


}
