package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotState1 extends CarrotState{

    CarrotState1(Carrot carrot) {
        super(carrot);
        setStateType(StateType.STATE1);
    }

    @Override
    public void incrementDay() {
        if (getDaysInCurrentState() == CARROT_STATE1_DURATION + 1) {
            carrot.setElementState(new CarrotState2(carrot));
            setDaysInCurrentState(1);
            setStateType(StateType.STATE2);
        }
    }
    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(carrot.getMAX_POINTS()*CARROT_STATE1_POINT_PERCENTAGE));

    }

    public void fertilize(){
        carrot.setElementState(new CarrotState3(carrot));
        setStateType(StateType.STATE3);
        setDaysInCurrentState(1);
    }
    @Override
    public String toString() {
        return "CarrotState1{" +
                "carrot=" + carrot +"stateDays=" + getDaysInCurrentState()+
                '}';
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() { // not necessary ?
//        return getStateType();
//    }
}
