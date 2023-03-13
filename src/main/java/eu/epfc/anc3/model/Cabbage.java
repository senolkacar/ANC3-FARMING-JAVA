package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class Cabbage extends Element{

    private CabbageState cabbageState;
    private static final int MAX_POINTS = 200;
    private int daysInCurrentState = 1;
    private IntegerProperty harvestScore = new SimpleIntegerProperty(0);
    private BooleanProperty hasGrass = new SimpleBooleanProperty(false);

    Cabbage() {
        elementType = ElementType.CABBAGE;
        cabbageState = new CabbageState1(this);
        stateType.set( StateType.STATE1);
    }

    public CabbageState getCabbageState() {
        return cabbageState;
    }

    public void setCabbageState(CabbageState cabbageState) {
        this.cabbageState = cabbageState;
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
        cabbageState.incrementDay();
    }

    public boolean hasGrass() {
        return hasGrass.get();
    }

    public BooleanProperty hasGrassProperty() {
        return hasGrass;
    }

    @Override
    public void setHasGrass(boolean hasGrass) {
        this.hasGrass.set(hasGrass);
    }

    @Override
    public void plantGrass(){
        cabbageState.plantGrass();
    }

    @Override
    public IntegerProperty getHarvestScore(){
        return harvestScore;
    }

    @Override
    public void   setElementHarvestScore() {
        cabbageState.setHarvestScore();
    }

    public void setHarvestScore(int harvestScore) {
        this.harvestScore.set(harvestScore);
    }

    @Override
    public  ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void setStateType(StateType stateType) {
        this.stateType.set(stateType);
    }
}
