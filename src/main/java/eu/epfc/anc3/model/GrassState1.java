package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

public class GrassState1 extends VegetableState{

    GrassState1(Element grass, StateType stateType, int daysInCurentState) {
        super(grass, stateType,1);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void setStateType(StateType stateType) {

    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (getDaysInCurrentState()==12+1) {
            stateType.set(StateType.STATE0);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {

    }
}
