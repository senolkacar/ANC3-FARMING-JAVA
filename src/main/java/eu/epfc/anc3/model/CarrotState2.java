package eu.epfc.anc3.model;

import javafx.scene.image.Image;

class CarrotState2 extends CarrotState{

    int getCarrotState1Duration () {
        return CARROT_STATE2_DURATION;
    }

    double getCarrotState1PointPercentage() {
        return CARROT_STATE2_POINT_PERCENTAGE;
    }

    public CarrotState2(Carrot carrot) {
        super(carrot);
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE2_DURATION + 1) {
            carrot.setCarrotState(new CarrotState3(carrot));
            carrot.setDaysInCurrentState(1);
        }
    }

    @Override
    public String toString() {
        return "CarrotState2{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }


}
