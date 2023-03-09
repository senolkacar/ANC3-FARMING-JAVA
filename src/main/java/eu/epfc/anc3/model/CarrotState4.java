package eu.epfc.anc3.model;

import javafx.scene.image.Image;

class CarrotState4 extends CarrotState{

    int getCarrotState1Duration () {
        return CARROT_STATE4_DURATION;
    }

    double getCarrotState1PointPercentage() {
        return CARROT_STATE4_POINT_PERCENTAGE;
    }

    public CarrotState4(Carrot carrot) {
        super(carrot);
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE4_DURATION + 1) {
            carrot.setCarrotState(new CarrotRotten(carrot));
            carrot.setDaysInCurrentState(1);
        }
    }

    @Override
    public String toString() {
        return "CarrotState4{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }
}
