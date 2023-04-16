package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState2 extends VegetableState{

    public CabbageState2(Element cabbage, StateType stateType,int daysInCurrentState) {
        super(cabbage,stateType,daysInCurrentState);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (element.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE2_DURATION
                || (!element.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE2_DURATION + 1)){
            element.state.set(new CabbageState3(element,StateType.STATE3,1));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(MAX_POINTS_CABBAGE*CABBAGE_STATE2_POINT_PERCENTAGE));
    }


}
