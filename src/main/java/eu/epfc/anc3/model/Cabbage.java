package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class Cabbage extends Element{

    private CabbageState cabbageState;
    //private ObjectProperty<StateType> stateType;
    private static final int MAX_POINTS = 200;
    private int daysInCurrentState = 1;
    private IntegerProperty harvestScore = new SimpleIntegerProperty(0);
    private StringProperty image = new SimpleStringProperty("cabbage1.png");// to delete
    private BooleanProperty hasGrass = new SimpleBooleanProperty(false);

    Cabbage() {
        elementType = ElementType.CABBAGE;
        cabbageState = new CabbageState1(this);
        stateType.set( StateType.STATE1);
    }

    public CabbageState getCabbageState() {
        return cabbageState;
    }

    void setCabbageState(CabbageState cabbageState) {
        this.cabbageState = cabbageState;
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
        cabbageState.incrementDay();
    }

    @Override
    public String getImage() {
        return image.get();
    }

    public StringProperty imageProperty() {
        return image;
    }

    void setImage(String image) {
        this.image.set(image);
    }

    boolean hasGrass() {
        return hasGrass.get();
    }

    BooleanProperty hasGrassProperty() {
        return hasGrass;
    }

    @Override
    void setHasGrass(boolean hasGrass) {
        this.hasGrass.set(hasGrass);
    }

    @Override
    void plantGrass(){
        cabbageState.plantGrass();
    }//plantGrass should be called by farmer ?

    @Override
    IntegerProperty getHarvestScore(){
        return harvestScore;
    }

    @Override
    void   setElementHarvestScore() {
        cabbageState.setHarvestScore();
    }

    void setHarvestScore(int harvestScore) {
        this.harvestScore.set(harvestScore);
    }

    @Override
    public  ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    void setStateType(StateType stateType) {
        this.stateType.set(stateType);
    }
}
