package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class Cabbage extends Element{

    //private ElementState cabbageState;
    private static final int MAX_POINTS = 200;
    //private IntegerProperty harvestScore = new SimpleIntegerProperty(0);
    //private StringProperty image = new SimpleStringProperty("cabbage1.png");// to delete
    private BooleanProperty hasGrass = new SimpleBooleanProperty();//set when plant cabbage. to check if parcel contains grass or not

    Cabbage() {
        elementType = ElementType.CABBAGE;
        elementState = new CabbageState1(this);
       // stateType.set( StateType.STATE1);
    }

    public ElementState getCabbageState() {
        return elementState;
    }

//    void setCabbageState(CabbageState cabbageState) {
//        this.elementState = cabbageState;
//    }

    int getMAX_POINTS() {
        return MAX_POINTS;
    }


    void incrementDay() {
        //incrementDaysInCurrentState();
        elementState.incrementDay();
    }

    boolean hasGrass() {
        return hasGrass.get();
    }

    BooleanProperty hasGrassProperty() {
        return hasGrass;
    }

//    @Override
//    void setHasGrass(boolean hasGrass) {
//        this.hasGrass.set(hasGrass);
//    }

//    @Override
//    void plantGrass(){
//        cabbageState.plantGrass();
//    }//plantGrass should be called by farmer ?

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
//    public  ObjectProperty<StateType> getStateType() {
//        return stateType;
//    }
//
//    @Override
//    void setStateType(StateType stateType) {
//        this.stateType.set(stateType);
//    }
}
