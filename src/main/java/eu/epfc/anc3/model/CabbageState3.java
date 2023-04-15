package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState3 extends CabbageState {

    public CabbageState3(Cabbage cabbage, StateType stateType) {
        super(cabbage,stateType);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE3_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE3_DURATION + 1)){
            cabbage.state.set(new CabbageState4(cabbage,StateType.STATE4));
            cabbage.setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE3_POINT_PERCENTAGE));
    }

}
