package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CarrotState2 extends CarrotState{

    CarrotState2(Carrot carrot, StateType stateType) {
        super(carrot, stateType);

    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }


    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE2_DURATION + 1) {
            setStateType(StateType.STATE3);
            carrot.state.set(new CarrotState3(carrot,StateType.STATE3 ));
            carrot.setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize(){
        setStateType(StateType.STATE3);
        carrot.state.set(new CarrotState3(carrot , StateType.STATE3));
        carrot.setDaysInCurrentState(1);
    }

    @Override
    public void setHarvestScore() {
        carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE2_POINT_PERCENTAGE));
    }

    @Override
    public String toString() {
        return "CarrotState2{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }


}
