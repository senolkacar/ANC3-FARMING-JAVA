package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageRotten extends VegetableState {

    public CabbageRotten(Element cabbage, StateType stateType, int daysInCurrentState) {
        super(cabbage,stateType,daysInCurrentState);
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        setHarvestScore();
        if (element.hasGrass() && getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -5
                || (!element.hasGrass() && getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION+1)){
            if(!element.hasGrass()){
                setDaysInCurrentState(getDaysInCurrentState()-1);
            }
            element.state.set(new CabbageRotten(element,StateType.STATE0,getDaysInCurrentState()));
            setStateType(StateType.STATE0);
            setHarvestScore();
        }
    }

    @Override
    public void fertilize() {    }

    @Override
    public void setHarvestScore() {
        harvestScore.set(-(int)(MAX_POINTS_CABBAGE* 0.1 *getDaysInCurrentState()));
    }

    @Override
    public String toString() {
        return "CabbageRotten{" +
                "element=" + element +
                ", daysInCurrentState=" + daysInCurrentState +
                ", stateType=" + stateType +
                ", harvestScore=" + harvestScore +
                '}';
    }
}
