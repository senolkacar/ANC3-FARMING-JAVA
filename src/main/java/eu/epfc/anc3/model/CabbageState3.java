package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState3 extends CabbageState {

    public CabbageState3(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATE3);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE3_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE3_DURATION + 1)){
            setStateType(StateType.STATE4);
            cabbage.setStateType(this.getStateType().get());
            cabbage.state = new CabbageState4(cabbage);
            //cabbage.state.setStateType(StateType.STATE4);
            cabbage.setDaysInCurrentState(1);
            //cabbage.setStateType(StateType.STATE4);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE3_POINT_PERCENTAGE));
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return cabbage.getStateType();
//    }
}
