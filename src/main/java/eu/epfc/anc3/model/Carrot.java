package eu.epfc.anc3.model;

import javafx.scene.image.ImageView;

class Carrot extends Element{

    private CarrotState carrotState;
    private final int MAX_POINTS = 100;
    private int daysInCurrentState = 1;

    Carrot() {
        elementType = ElementType.CARROT;
        carrotState = new CarrotState1(this);
    }

    public CarrotState getCarrotState() {
        return carrotState;
    }

    public void setCarrotState(CarrotState carrotState) {
        this.carrotState = carrotState;
    }

    int getMAX_POINTS() {
        return MAX_POINTS;
    }

    int getDaysInCurrentState() {
        return daysInCurrentState;
    }

    public void setDaysInCurrentState(int daysInCurrentState) {
        this.daysInCurrentState = daysInCurrentState;
    }

    void incrementDaysInCurrentState() {
        this.daysInCurrentState++;
    }

    public void incrementDay() {
        incrementDaysInCurrentState();
        carrotState.incrementDay();

    }
}
