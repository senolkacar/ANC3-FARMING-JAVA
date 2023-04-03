package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState2 extends CabbageState{

//    String image = "cabbage3.png";

    CabbageState2(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATE2);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE2_DURATION
                || (!cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE2_DURATION + 1)){
            cabbage.setElementState(new CabbageState3(cabbage));
            setDaysInCurrentState(1);
            setStateType(StateType.STATE3);
        }
    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE2_POINT_PERCENTAGE));
    }

//
//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return getStateType();
//    }

    @Override
    public void fertilize() {

    }
}
