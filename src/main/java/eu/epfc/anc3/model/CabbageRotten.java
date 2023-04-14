package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageRotten extends CabbageState {


    public CabbageRotten(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATEROTTEN);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -5
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION+1)){
            if(!cabbage.hasGrass()){
                cabbage.setDaysInCurrentState(cabbage.getDaysInCurrentState()-1);
            }
            cabbage.setElementHarvestScore();
            cabbage.state.setStateType(StateType.STATE0);
            cabbage.setStateType(this.getStateType().get());
            //stateType.set(StateType.STATE0);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore(-(int)(cabbage.getMAX_POINTS()* 0.1 *cabbage.getDaysInCurrentState()));
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }


}
