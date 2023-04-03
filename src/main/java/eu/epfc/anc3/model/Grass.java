package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Grass extends Element {

    private int daysInCurrentState = 1;
    //private StringProperty image = new SimpleStringProperty("grass.png");

    Grass() {
        elementType = ElementType.GRASS;
        if (elementState != null)
        elementState.setStateType(StateType.STATE1);

    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }

    int getDaysInCurrentState() {
        return daysInCurrentState;
    }

    @Override
    void incrementDay() {
        this.daysInCurrentState++;
        if (getDaysInCurrentState()==12+1 && elementState != null) {
            elementState.setStateType(StateType.STATE0);
        }
    }
//
//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return stateType;
//    }
//
//    @Override
//    void setStateType(StateType stateType) {
//        this.stateType.set(stateType);
//    }



}
