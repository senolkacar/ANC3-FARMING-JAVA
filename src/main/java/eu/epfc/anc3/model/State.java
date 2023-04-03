package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public interface State {
    public ObjectProperty<StateType> stateType = new SimpleObjectProperty<>();
    int daysInCurrentState = 1;
    ObjectProperty<StateType> getStateType();
    public void setStateType(StateType stateType);

    public void fertilize();
    abstract void incrementDay();

    abstract void setHarvestScore();
    abstract int getHarvestScore();



}
