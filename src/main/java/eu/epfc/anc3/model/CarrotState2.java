package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CarrotState2 extends VegetableState{

    CarrotState2(Element carrot, StateType stateType,int daysInCurrentState) {
        super(carrot, stateType,1);

    }


    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (getDaysInCurrentState() == CARROT_STATE2_DURATION + 1) {
            setStateType(StateType.STATE3);
            element.state.set(new CarrotState3(element,StateType.STATE3,1 ));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize(){
        setStateType(StateType.STATE3);
        element.state.set(new CarrotState3(element , StateType.STATE3,1));
        setDaysInCurrentState(1);
    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(MAX_POINTS_CARROT*CARROT_STATE2_POINT_PERCENTAGE));
        //carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE2_POINT_PERCENTAGE));
    }



}
