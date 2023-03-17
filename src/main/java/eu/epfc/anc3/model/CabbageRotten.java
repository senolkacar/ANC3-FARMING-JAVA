package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageRotten extends CabbageState {

    String image = "0";

    CabbageRotten(Cabbage cabbage) {
        super(cabbage);
    }

    @Override
    void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -5
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION+1)){
            cabbage.setImage(image);
            //cabbage disappears on 11th day in dirt, but for the formula in harvestscore
            //we need to pass the last rotten day of the cabbage which is 10th day
            if(!cabbage.hasGrass()){
                cabbage.setDaysInCurrentState(cabbage.getDaysInCurrentState()-1);
            }
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
