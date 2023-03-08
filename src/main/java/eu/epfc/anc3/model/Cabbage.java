package eu.epfc.anc3.model;

import javafx.beans.property.SimpleIntegerProperty;

class Cabbage extends Element implements VegetableState{

    SimpleIntegerProperty stateProperty = new SimpleIntegerProperty(1);
    private final int MAX_POINTS = 200;
    private final double STATE_1_PERCENTAGE = 0;
    private final double STATE_2_PERCENTAGE = 0;
    private final double STATE_3_PERCENTAGE = 0.75;
    private final double STATE_4_PERCENTAGE = 1;
    private final double STATE_5_PERCENTAGE = 0;

    private int state;
    private int daysSincePlanting;
    private int duration =0;

    Cabbage() {
        elementType = ElementType.CABBAGE;
        this.state = 1;
        this.daysSincePlanting = 0;
    }
    @Override
    public void incrementDay() {
        daysSincePlanting++;
        duration++;
        if (duration % 5 == 0 && state==1) {
            state++;
            stateProperty.set(state);
            duration = 0;
        }else if(duration % 4 == 0 && state==2){
            state++;
            stateProperty.set(state);
            duration = 0;
        }else if(duration % 3 == 0 && state==3){
            state++;
            stateProperty.set(state);
            duration = 0;
        } else if(duration % 2 == 0 && state==4){
            state++;
            stateProperty.set(state);
            duration = 0;
        }else if (duration %10==0 && state == 5){
            state++;
            stateProperty.set(state);
        }
    }
    @Override
    public double harvest() {
        double points = 0;
        switch (this.state) {
            case 1:
                points = MAX_POINTS * STATE_1_PERCENTAGE;
                break;
            case 2:
                points = MAX_POINTS * STATE_2_PERCENTAGE;
                break;
            case 3:
                points = MAX_POINTS * STATE_3_PERCENTAGE;
                break;
            case 4:
                points = MAX_POINTS * STATE_4_PERCENTAGE;
                break;
            case 5:
                points = MAX_POINTS * STATE_5_PERCENTAGE;
                break;
        }
        return points;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public SimpleIntegerProperty getStateProperty() {
        return stateProperty;
    }
}
