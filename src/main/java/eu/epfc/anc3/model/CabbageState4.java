package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState4 extends VegetableState {

    public CabbageState4(Element cabbage, StateType stateType, int daysInCurrentState) {
        super(cabbage,stateType,daysInCurrentState);

    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (element.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE4_DURATION
                || (!element.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE4_DURATION + 1)){
            element.state.set(new CabbageRotten(element,StateType.STATEROTTEN,1));
            setDaysInCurrentState(1);

        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(MAX_POINTS_CABBAGE*CABBAGE_STATE4_POINT_PERCENTAGE));

    }

}
