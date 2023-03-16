package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageRotten extends CabbageState {

    String image = "0";

    CabbageRotten(Cabbage cabbage) {
        super(cabbage);
    }

    @Override
    void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -4
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION + 1)){
            cabbage.setImage(image);
            cabbage.setDaysInCurrentState(cabbage.getDaysInCurrentState()-1);
            cabbage.setElementHarvestScore();
            cabbage.setStateType(StateType.STATE0);

        }
    }

    @Override
    void setHarvestScore() {
        cabbage.setHarvestScore(-(int)(cabbage.getMAX_POINTS()* 0.1 *cabbage.getDaysInCurrentState()));
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return cabbage.getStateType();
    }
}
