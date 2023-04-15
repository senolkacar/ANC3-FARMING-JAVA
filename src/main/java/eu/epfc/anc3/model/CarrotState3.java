package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CarrotState3 extends CarrotState{

    CarrotState3(Carrot carrot,StateType stateType) {
        super(carrot, stateType);

    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }


    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE3_DURATION + 1) {
            setStateType(StateType.STATE4);
            carrot.state.set(new CarrotState4(carrot,StateType.STATE4));
            carrot.setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE3_POINT_PERCENTAGE));
    }

    @Override
    public String toString() {
        return "CarrotState3{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }
}
