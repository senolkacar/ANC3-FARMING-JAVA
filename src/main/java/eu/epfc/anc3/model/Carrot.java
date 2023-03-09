package eu.epfc.anc3.model;

import javafx.scene.image.ImageView;

class Carrot extends Element{

    //private CarrotState carrotState;
    private StateType stateType = StateType.STATE1;
    //private ImageView imageView = new ImageView();

    private final int MAX_POINTS = 100;
    private int daysInCurrentState ;
    private int daysSincePlanting;

    Carrot() {
        elementType = ElementType.CARROT;
        daysSincePlanting = 1;
        daysInCurrentState=1;
      //  carrotState = new CarrotState1();
    }

    StateType getStateType() {
        return stateType;
    }

    void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

    int getMAX_POINTS() {
        return MAX_POINTS;
    }

    int getDaysInCurrentState() {
        return daysInCurrentState;
    }


    void incrementDaysInCurrentState() {
        this.daysInCurrentState++;
    }

    int getDaysSincePlanting() {
        return daysSincePlanting;
    }

    void incrementDaysSincePlanting() {
        this.daysSincePlanting ++;
    }

    public void incrementDay() {
        incrementDaysSincePlanting();
        incrementDaysInCurrentState();

    }
}
