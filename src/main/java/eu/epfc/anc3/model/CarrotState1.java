package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CarrotState1 extends CarrotState{

    CarrotState1(Carrot carrot, StateType stateType) {
        super(carrot, stateType);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return  stateType;
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE1_DURATION + 1) {
            setStateType(StateType.STATE2);
            carrot.state.set(new CarrotState2(carrot,StateType.STATE2));
            carrot.setDaysInCurrentState(1);
        }
    }

    @Override
    public void setHarvestScore() {
        carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE1_POINT_PERCENTAGE));
    }
    @Override
    public void fertilize(){
        setStateType(StateType.STATE3);
        carrot.state.set(new  CarrotState3(carrot,StateType.STATE3));
        carrot.setDaysInCurrentState(1);
    }

    @Override
    public String toString() {
        return "CarrotState1{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }

}
