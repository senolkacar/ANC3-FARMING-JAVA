package eu.epfc.anc3.model;

import javafx.beans.property.*;
import javafx.scene.image.ImageView;

public class Carrot extends Element{

    //private ElementState carrotState;
    private static final int MAX_POINTS = 100;
    //private int daysInCurrentState = 1;
  //  private IntegerProperty harvestScore = new SimpleIntegerProperty(0);
   // private BooleanProperty isFertilied = new SimpleBooleanProperty(false);

    Carrot() {
        elementType = ElementType.CARROT;
        elementState = new CarrotState1(this);
//        stateType.set(StateType.STATE1);
    }

//    public ElementState getCarrotState() {
//        return carrotState;
//    }
//
//     void setCarrotState(CarrotState carrotState) {
//        this.carrotState = carrotState;
//    }

    int getMAX_POINTS() {
        return MAX_POINTS;
    }
    void incrementDay() {
        //incrementDaysInCurrentState();
        elementState.incrementDay();
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
        elementState.fertilize();
    }

//    @Override
//    IntegerProperty getHarvestScore(){
//        return harvestScore;
//    }
//
//    @Override
//    void setElementHarvestScore() {
//        elementState.setHarvestScore();
//    }
//
//    void setHarvestScore(int harvestScore) {
//        this.harvestScore.set(harvestScore);
//    }

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
