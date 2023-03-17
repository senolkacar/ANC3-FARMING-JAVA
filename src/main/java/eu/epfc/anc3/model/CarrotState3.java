package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotState3 extends CarrotState{

    CarrotState3(Carrot carrot) {
        super(carrot);
    }

    @Override
    void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE3_DURATION + 1) {
            carrot.setCarrotState(new CarrotState4(carrot));
            carrot.setDaysInCurrentState(1);
            carrot.setStateType(StateType.STATE4);
        }
    }

    @Override
    void setHarvestScore() {
        carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE3_POINT_PERCENTAGE));
    }

    @Override
    public String toString() {
        return "CarrotState3{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return carrot.getStateType();
    }
}
