package eu.epfc.anc3.model;

import javafx.beans.property.*;
import javafx.scene.image.ImageView;

public class Carrot extends Element{

    private CarrotState carrotState;
    private ObjectProperty<StateType> stateType;
    private static final int MAX_POINTS = 100;
    private int daysInCurrentState = 1;
    private IntegerProperty harvestScore = new SimpleIntegerProperty(0);
    private StringProperty image = new SimpleStringProperty("carrot1.png");
    private BooleanProperty isFertilied = new SimpleBooleanProperty(false);

    Carrot() {
        elementType = ElementType.CARROT;
        carrotState = new CarrotState1(this);
        stateType.set(StateType.STATE1);
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

    public boolean isIsFertilied() {
        return isFertilied.get();
    }

    public BooleanProperty isFertiliedProperty() {
        return isFertilied;
    }

    @Override
    public void setIsFertilied(boolean isFertilied) {
        this.isFertilied.set(isFertilied);
    }

    @Override
    public void fertilize(){
        carrotState.fertilize();
    }

    @Override
    public IntegerProperty getHarvestScore(){
        return harvestScore;
    }

    @Override
    public void   setElementHarvestScore() {
        carrotState.setHarvestScore();
    }

    public void setHarvestScore(int harvestScore) {
        this.harvestScore.set(harvestScore);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void setStateType(StateType stateType) {
        this.stateType.set(stateType);
    }
}
