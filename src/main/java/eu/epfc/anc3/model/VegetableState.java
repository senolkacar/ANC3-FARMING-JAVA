package eu.epfc.anc3.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

abstract class VegetableState implements State {


    protected Element element;
    protected int daysInCurrentState;
    public ObjectProperty<StateType> stateType = new SimpleObjectProperty<>();
    public IntegerProperty harvestScore = new SimpleIntegerProperty(0);

    VegetableState (Element element, StateType stateType, int daysInCurrentState) {
        this.element = element;
        this.stateType.set(stateType);
        this.daysInCurrentState = daysInCurrentState;

    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void setStateType(StateType stateType) {
        this.stateType.set(stateType);
    }

    @Override
    public String toString() {
        return "VegetableState{" +
                "element=" + element +
                ", daysInCurrentState=" + daysInCurrentState +
                ", stateType=" + stateType +
                ", harvestScore=" + harvestScore +
                '}';
    }

    @Override
    public int getDaysInCurrentState() {
        return daysInCurrentState;
    }

    @Override
    public void setDaysInCurrentState(int daysInCurrentState) {
        this.daysInCurrentState = daysInCurrentState;
    }

//    @Override
//    public void incrementDaysInCurrentState() {
//        this.daysInCurrentState++;
//    }

    @Override
    public void setHarvestScore(){

    }

    @Override
    public IntegerProperty getHarvestScore(){
        return harvestScore;
    }

}
