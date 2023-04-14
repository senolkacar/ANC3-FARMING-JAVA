package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

abstract class CabbageState implements State {
    public static final int CABBAGE_STATE1_DURATION = 5;
    public static final int CABBAGE_STATE2_DURATION = 4;
    public static final int CABBAGE_STATE3_DURATION = 3;
    public static final int CABBAGE_STATE4_DURATION = 2;
    public static final int CABBAGE_ROTTEN_DURATION = 10;

    public static double CABBAGE_STATE1_POINT_PERCENTAGE = 0;
    public static double CABBAGE_STATE2_POINT_PERCENTAGE = 0;
    public static double CABBAGE_STATE3_POINT_PERCENTAGE = 0.75;
    public static double CABBAGE_STATE4_POINT_PERCENTAGE = 1;

    protected Cabbage cabbage;
    public ObjectProperty<StateType> stateType = new SimpleObjectProperty<>();

    CabbageState (Cabbage cabbage) {
        this.cabbage = cabbage;

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
