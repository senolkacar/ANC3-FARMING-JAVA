package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CarrotState1 extends CarrotState{
//    String image = "carrot2.png";

    CarrotState1(Carrot carrot) {
        super(carrot);
    }

    @Override
    void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE1_DURATION + 1) {
            carrot.setCarrotState(new CarrotState2(carrot));
            carrot.setDaysInCurrentState(1);
//            carrot.setImage(image);//
            carrot.setStateType(StateType.STATE2);
        }
    }

    @Override
    void setHarvestScore() {
        carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE1_POINT_PERCENTAGE));
    }

    void fertilize(){
        carrot.setCarrotState(new CarrotState3(carrot));
        carrot.setStateType(StateType.STATE3);
        carrot.setDaysInCurrentState(1);
//        carrot.setImage("carrot3.png");//
    }

    @Override
    public String toString() {
        return "CarrotState1{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }

    @Override
    public ObjectProperty<StateType> getStateType() { // not necessary ?
        return carrot.getStateType();
    }
}
