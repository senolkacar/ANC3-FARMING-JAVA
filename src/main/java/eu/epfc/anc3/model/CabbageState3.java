package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState3 extends CabbageState {

    CabbageState3(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATE3);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE3_DURATION
                || (!cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE3_DURATION + 1)){
            cabbage.setElementState(new CabbageState4(cabbage));
            setDaysInCurrentState(1);
            setStateType(StateType.STATE4);
        }
    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE3_POINT_PERCENTAGE));
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return getStateType();
//    }

    @Override
    public void fertilize() {

    }
}
