package eu.epfc.anc3.model;

import javafx.scene.image.Image;

class CarrotState3 extends CarrotState{

    int getCarrotState1Duration () {
        return CARROT_STATE3_DURATION;
    }

    double getCarrotState1PointPercentage() {
        return CARROT_STATE3_POINT_PERCENTAGE;
    }

    public CarrotState3(Carrot carrot) {
        super(carrot);
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE3_DURATION + 1) {
            carrot.setCarrotState(new CarrotState4(carrot));
            carrot.setDaysInCurrentState(1);
        }
    }

    @Override
    public String toString() {
        return "CarrotState3{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }
}
