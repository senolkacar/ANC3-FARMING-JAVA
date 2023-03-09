package eu.epfc.anc3.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CarrotState1 extends CarrotState{

    public CarrotState1(Carrot carrot) {
        super(carrot);
    }

    int getCarrotState1Duration () {
        return CARROT_STATE1_DURATION;
    }

    double getCarrotState1PointPercentage() {
      return CARROT_STATE1_POINT_PERCENTAGE;
    }


    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE1_DURATION + 1) {
            carrot.setCarrotState(new CarrotState2(carrot));
            carrot.setDaysInCurrentState(1);
        }
    }

    @Override
    public String toString() {
        return "CarrotState1{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }
}
