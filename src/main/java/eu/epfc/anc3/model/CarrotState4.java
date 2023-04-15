package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CarrotState4 extends CarrotState{

    CarrotState4(Carrot carrot, StateType stateType) {
        super(carrot,stateType);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE4_DURATION + 1) {
            setStateType(StateType.STATEROTTEN);
            carrot.state.set(new  CarrotRotten(carrot,StateType.STATEROTTEN));
            carrot.setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE4_POINT_PERCENTAGE));
    }

    @Override
    public String toString() {
        return "CarrotState4{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }

}
