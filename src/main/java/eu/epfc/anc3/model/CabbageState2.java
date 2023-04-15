package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState2 extends CabbageState{

    public CabbageState2(Cabbage cabbage, StateType stateType) {
        super(cabbage,stateType);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE2_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE2_DURATION + 1)){
            cabbage.state.set(new CabbageState3(cabbage,StateType.STATE3));
            cabbage.setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE2_POINT_PERCENTAGE));
    }


}
