package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState4 extends CabbageState {

    CabbageState4(Cabbage cabbage) {
        super(cabbage);
    }

    @Override
    void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE4_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE4_DURATION + 1)){
            cabbage.setCabbageState(new CabbageRotten(cabbage));
            cabbage.setDaysInCurrentState(1);
            cabbage.setStateType(StateType.STATEROTTEN);
        }
    }

    @Override
    void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE4_POINT_PERCENTAGE));
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return cabbage.getStateType();
//    }
}
