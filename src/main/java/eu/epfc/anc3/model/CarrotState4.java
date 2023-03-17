package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.ImageView;

class CarrotState4 extends CarrotState{
//    String image = "rotten_carrot.png";

    CarrotState4(Carrot carrot) {
        super(carrot);
    }

    @Override
    void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE4_DURATION + 1) {
            carrot.setCarrotState(new CarrotRotten(carrot));
            carrot.setDaysInCurrentState(1);
//            carrot.setImage(image);
            carrot.setStateType(StateType.STATEROTTEN);
        }
    }

    @Override
    void setHarvestScore() {
        carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE4_POINT_PERCENTAGE));
    }

    @Override
    public String toString() {
        return "CarrotState4{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return carrot.getStateType();
    }
}
