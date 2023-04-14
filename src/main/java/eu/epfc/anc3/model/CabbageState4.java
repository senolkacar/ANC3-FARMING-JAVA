package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState4 extends CabbageState {

    public CabbageState4(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATE4);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE4_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE4_DURATION + 1)){
            setStateType(StateType.STATEROTTEN);
            cabbage.setStateType(this.getStateType().get());
            cabbage.state = new CabbageRotten(cabbage);
            //cabbage.state.setStateType(StateType.STATEROTTEN);
            cabbage.setDaysInCurrentState(1);

        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE4_POINT_PERCENTAGE));
    }

}
