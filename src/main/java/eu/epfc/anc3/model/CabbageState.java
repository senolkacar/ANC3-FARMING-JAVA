package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

abstract class CabbageState implements State {


    protected Cabbage cabbage;
    public ObjectProperty<StateType> stateType = new SimpleObjectProperty<>();

    CabbageState (Cabbage cabbage, StateType stateType) {
        this.cabbage = cabbage;
        this.stateType.set(stateType);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void setStateType(StateType stateType) {
        this.stateType.set(stateType);
    }

}
