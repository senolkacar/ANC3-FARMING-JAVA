package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CarrotState4 extends VegetableState{

    CarrotState4(Element carrot, StateType stateType,int daysInCurrentState) {
        super(carrot,stateType,1);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (getDaysInCurrentState() == CARROT_STATE4_DURATION + 1) {
            setStateType(StateType.STATEROTTEN);
            element.state.set(new  CarrotRotten(element,StateType.STATEROTTEN,1));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(MAX_POINTS_CARROT*CARROT_STATE4_POINT_PERCENTAGE));
    }


}
