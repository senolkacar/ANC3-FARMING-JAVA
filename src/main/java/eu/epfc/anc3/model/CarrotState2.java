package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotState2 extends CarrotState{

    CarrotState2(Carrot carrot) {
        super(carrot);
        setStateType(StateType.STATE2);
    }

    @Override
    public void incrementDay() {
        if (getDaysInCurrentState() == CARROT_STATE2_DURATION + 1) {
            carrot.setElementState(new CarrotState3(carrot));
            setDaysInCurrentState(1);
            setStateType(StateType.STATE3);
        }
    }

    public void fertilize(){
        carrot.setElementState(new CarrotState3(carrot));
        setStateType(StateType.STATE3);
        setDaysInCurrentState(1);
    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(carrot.getMAX_POINTS()*CARROT_STATE2_POINT_PERCENTAGE));
    }

    @Override
    public String toString() {
        return "CarrotState2{" +
                "carrot=" + carrot +"stateDays=" + getDaysInCurrentState()+
                '}';
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return getStateType();
//    }

}
