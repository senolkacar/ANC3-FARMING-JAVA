package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState2 extends CabbageState{

    public CabbageState2(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATE2);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;

    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE2_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE2_DURATION + 1)){
            setStateType(StateType.STATE3);
            cabbage.setStateType(this.getStateType().get());
            cabbage.state = new CabbageState3(cabbage);
            //cabbage.state.setStateType(StateType.STATE3);
            cabbage.setDaysInCurrentState(1);
            //cabbage.setStateType(StateType.STATE3);
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
