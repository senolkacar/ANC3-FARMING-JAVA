package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CarrotState3 extends VegetableState{

    CarrotState3(Element carrot,StateType stateType,int daysInCurrentState) {
        super(carrot, stateType,1);

    }


    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (getDaysInCurrentState() == CARROT_STATE3_DURATION + 1) {
            setStateType(StateType.STATE4);
            element.state.set(new CarrotState4(element,StateType.STATE4,1));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(MAX_POINTS_CARROT*CARROT_STATE3_POINT_PERCENTAGE));
    }


}
