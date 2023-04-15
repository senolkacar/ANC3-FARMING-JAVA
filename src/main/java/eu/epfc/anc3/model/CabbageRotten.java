package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageRotten extends CabbageState {

    public CabbageRotten(Cabbage cabbage, StateType stateType) {
        super(cabbage,stateType);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -5
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION+1)){
            if(!cabbage.hasGrass()){
                cabbage.setDaysInCurrentState(cabbage.getDaysInCurrentState()-1);
            }
            cabbage.setElementHarvestScore();
            cabbage.state.set(new CabbageState1(cabbage,StateType.STATE0));
            setStateType(StateType.STATE0);
        }
    }

    @Override
    public void fertilize() {    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore(-(int)(cabbage.getMAX_POINTS()* 0.1 *cabbage.getDaysInCurrentState()));
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }


}
