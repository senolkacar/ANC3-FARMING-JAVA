package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotState2 extends CarrotState{
    public CarrotState2(Carrot carrot) {
        super(carrot);
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE2_DURATION + 1) {
            carrot.setCarrotState(new CarrotState3(carrot));
            carrot.setDaysInCurrentState(1);
            carrot.setStateType(StateType.STATE3);
        }
    }

    public void fertilize(){
        carrot.setCarrotState(new CarrotState3(carrot));
        carrot.setDaysInCurrentState(1);
        carrot.setStateType(StateType.STATE3);
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
    @Override
    public ObjectProperty<StateType> getStateType() {
        return carrot.getStateType();
    }
}
