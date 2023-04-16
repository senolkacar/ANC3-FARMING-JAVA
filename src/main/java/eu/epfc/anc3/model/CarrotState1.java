package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CarrotState1 extends VegetableState{

    CarrotState1(Element carrot, StateType stateType,int daysInCurrentState) {
        super(carrot, stateType, daysInCurrentState);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return  stateType;
    }

    @Override
    public void incrementDay() {
        if (getDaysInCurrentState() == CARROT_STATE1_DURATION + 1) {
            setStateType(StateType.STATE2);
            element.state.set(new CarrotState2(element,StateType.STATE2,1));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(MAX_POINTS_CARROT*CARROT_STATE1_POINT_PERCENTAGE));
        //carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE1_POINT_PERCENTAGE));
    }
    @Override
    public void fertilize(){
        setStateType(StateType.STATE3);
        element.state.set(new  CarrotState3(element,StateType.STATE3,1));
        setDaysInCurrentState(1);
    }

}
