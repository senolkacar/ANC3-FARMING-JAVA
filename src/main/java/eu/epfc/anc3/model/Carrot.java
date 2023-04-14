package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class Carrot extends Element{

    //private CarrotState carrotState;
    private static final int MAX_POINTS = 100;
    private int daysInCurrentState = 1;
    private IntegerProperty harvestScore = new SimpleIntegerProperty(0);
    //private BooleanProperty isFertilied = new SimpleBooleanProperty(false);

    Carrot() {
        elementType = ElementType.CARROT;
        state = new CarrotState1(this,StateType.STATE1);
        stateType.set(state.getStateType().get());
        //stateType.set(StateType.STATE1);
        setIsVegetable(true);
    }

//    public CarrotState getCarrotState() {
//        return carrotState;
//    }
//
//     void setCarrotState(CarrotState carrotState) {
//        this.carrotState = carrotState;
//    }

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
        //carrotState.incrementDay();
        state.incrementDay();
    }

//    boolean isIsFertilied() {
//        return isFertilied.get();
//    }
//
//     BooleanProperty isFertiliedProperty() {
//        return isFertilied;
//    }
//
//    @Override
//    void setIsFertilied(boolean isFertilied) {
//        this.isFertilied.set(isFertilied);
//    }

    @Override
    void fertilize(){
        state.fertilize();
    }

    @Override
    IntegerProperty getHarvestScore(){
        return harvestScore;
    }

    @Override
    void setElementHarvestScore() {
        state.setHarvestScore();
    }

    void setHarvestScore(int harvestScore) {
        this.harvestScore.set(harvestScore);
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return stateType;
//    }
//
//    @Override
//    void setStateType(StateType stateType) {
//        this.stateType.set(stateType);
//    }
}
