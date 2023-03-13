package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Grass extends Element {

    private int daysInCurrentState = 1;
    private ObjectProperty<StateType> stateType;
    private StringProperty image = new SimpleStringProperty("grass.png");

    Grass() {
        elementType = ElementType.GRASS;
        stateType.set(StateType.STATE1);
    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }

    int getDaysInCurrentState() {
        return daysInCurrentState;
    }

    @Override
    public void incrementDay() {
        this.daysInCurrentState++;
        if (getDaysInCurrentState()==12+1) {
           this.setStateType(StateType.STATE0);
        }
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

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void setStateType(StateType stateType) {
        this.stateType.set(stateType);
    }



}
