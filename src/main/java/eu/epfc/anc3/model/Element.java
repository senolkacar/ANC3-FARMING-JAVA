package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.Objects;

public abstract class Element  {

    public ElementType elementType;
    public ObjectProperty<StateType> stateType = new SimpleObjectProperty<>();
    private BooleanProperty isFertilied = new SimpleBooleanProperty(false);
    private BooleanProperty hasGrass = new SimpleBooleanProperty();
    private BooleanProperty isVegetable = new SimpleBooleanProperty(false);

    public ElementType getType() {
        return elementType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return elementType == element.elementType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementType);
    }

    void incrementDay() {
    }

    @Override
    public String toString(){
        return elementType.toString() +"stateType : " + getStateType() ;
    }

    void setIsFertilied(boolean isFertilied) {
        this.isFertilied.set(isFertilied);
    }

    void fertilize(){
    }

    public boolean hasGrass() {
        return hasGrass.get();
    }

    public BooleanProperty hasGrassProperty() {
        return hasGrass;
    }

    void setHasGrass(boolean hasGrass) {
        this.hasGrass.set(hasGrass);
    }


    IntegerProperty getHarvestScore(){
        return new SimpleIntegerProperty();
    }

    void setElementHarvestScore(){}

    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    void setStateType(StateType stateType) {
        this.stateType.set(stateType);
    }

    boolean getIsVegetable() {
        return isVegetable.get();
    }

    BooleanProperty getIsVegetableProperty() {
        return isVegetable;
    }

    void setIsVegetable(boolean isVegetable) {
        this.isVegetable.set(isVegetable);
    }
}
