package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageRotten extends CabbageState {

    public CabbageRotten(Cabbage cabbage) {
        super(cabbage);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -4
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION + 1)){
            cabbage.setStateType(StateType.STATE0);
            //cabbage.setHarvestScore(-(int)(cabbage.getMAX_POINTS()));
            cabbage.setElementHarvestScore();//TODO WITH CARROT

        }
    }

    @Override
    public void setHarvestScore() {
        if (cabbage.getStateType().get() == StateType.STATE0) {
            cabbage.setHarvestScore(-(int)(cabbage.getMAX_POINTS()));
        } else
        cabbage.setHarvestScore(-(int)(cabbage.getMAX_POINTS()* 0.1 *cabbage.getDaysInCurrentState()));
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return cabbage.getStateType();
    }
}
