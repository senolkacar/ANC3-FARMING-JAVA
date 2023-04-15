package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

public interface State {
    ObjectProperty<StateType> getStateType();

    void setStateType(StateType stateType);

    void incrementDay();

    void fertilize();

    void setHarvestScore();

}
