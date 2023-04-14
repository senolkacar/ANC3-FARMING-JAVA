package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class Grass extends Element {

    private int daysInCurrentState = 1;

    Grass() {
        elementType = ElementType.GRASS;
        state = new GrassState1(this,StateType.STATE1);
        //stateType.set(StateType.STATE1);
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
        state.incrementDay();
    }

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
