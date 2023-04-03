package eu.epfc.anc3.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class ElementState implements State {
    public ObjectProperty<StateType> stateType = new SimpleObjectProperty<>();
    public IntegerProperty harvestScore = new SimpleIntegerProperty(0);
    int daysInCurrentState = 1;
    int getDaysInCurrentState() {
        return daysInCurrentState;
    }

    void setDaysInCurrentState(int daysInCurrentState) {
        this.daysInCurrentState = daysInCurrentState;
    }

    void incrementDaysInCurrentState() {
        this.daysInCurrentState++;
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }
    @Override
    public void setStateType(StateType stateType) {
        this.stateType.set(stateType);
    }

    @Override
    public int getHarvestScore() {
        return harvestScore.get();
    }


}
