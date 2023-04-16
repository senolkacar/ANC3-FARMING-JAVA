package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageRotten extends VegetableState {

    public CabbageRotten(Element cabbage, StateType stateType, int daysInCurrentState) {
        super(cabbage,stateType,daysInCurrentState);
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (element.hasGrass() && getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -5
                || (!element.hasGrass() && getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION+1)){
            if(!element.hasGrass()){
                setDaysInCurrentState(getDaysInCurrentState()-1);
            }
            setHarvestScore();
            element.state.set(new CabbageState1(element,StateType.STATE0,1));
            setStateType(StateType.STATE0);
        }
    }

    @Override
    public void fertilize() {    }

    @Override
    public void setHarvestScore() {
        harvestScore.set(-(int)(MAX_POINTS_CABBAGE* 0.1 *getDaysInCurrentState()));
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }


}
