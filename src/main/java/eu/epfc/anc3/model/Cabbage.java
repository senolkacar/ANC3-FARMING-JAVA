package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class Cabbage extends Element{

    private CabbageState cabbageState;
    private static final int MAX_POINTS = 200;
    private int daysInCurrentState = 1;
    private IntegerProperty harvestScore = new SimpleIntegerProperty(0);
    private StringProperty image = new SimpleStringProperty("cabbage1.png");
    private BooleanProperty hasGrass = new SimpleBooleanProperty(false);

    Cabbage() {
        elementType = ElementType.CABBAGE;
        cabbageState = new CabbageState1(this);
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

    @Override
    public String getImage() {
        return image.get();
    }

    public StringProperty imageProperty() {
        return image;
    }

    public void setImage(String image) {
        this.image.set(image);
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
}
