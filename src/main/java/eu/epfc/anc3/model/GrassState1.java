package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

public class GrassState1 extends GrassState{

    GrassState1(Grass grass, StateType stateType) {
        super(grass, stateType);
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
        if (grass.getDaysInCurrentState()==12+1) {
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
