package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class Carrot extends Element{

    private static final int MAX_POINTS = 100;
    private int daysInCurrentState = 1;
    private IntegerProperty harvestScore = new SimpleIntegerProperty(0);

    Carrot() {
        elementType = ElementType.CARROT;
        state.set(new CarrotState1(this,StateType.STATE1));
        setIsVegetable(true);
    }

    int getMAX_POINTS() {
        return MAX_POINTS;
    }

    int getDaysInCurrentState() {
        return daysInCurrentState;
    }

    void setDaysInCurrentState(int daysInCurrentState) {
        this.daysInCurrentState = daysInCurrentState;
    }

    void incrementDaysInCurrentState() {
        this.daysInCurrentState++;
    }

    void incrementDay() {
        incrementDaysInCurrentState();
        state.get().incrementDay();
    }

    @Override
    void fertilize(){
        state.get().fertilize();
    }

    @Override
    IntegerProperty getHarvestScore(){
        return harvestScore;
    }

    @Override
    void setElementHarvestScore() {
        state.get().setHarvestScore();
    }

    void setHarvestScore(int harvestScore) {
        this.harvestScore.set(harvestScore);
    }

}
