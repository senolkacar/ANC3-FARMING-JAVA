package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState2 extends CabbageState{
    public CabbageState2(Cabbage cabbage) {
        super(cabbage);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE2_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE2_DURATION + 1)){
            cabbage.setCabbageState(new CabbageState3(cabbage));
            cabbage.setDaysInCurrentState(1);
            cabbage.setStateType(StateType.STATE3);
        }
    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE2_POINT_PERCENTAGE));
    }
    @Override
    public ObjectProperty<StateType> getStateType() {
        return cabbage.getStateType();
    }
}
