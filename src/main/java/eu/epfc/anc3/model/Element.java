package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.Objects;

public abstract class Element  {

    public ElementType elementType;
    public ObjectProperty<StateType> stateType = new SimpleObjectProperty<>();
    private BooleanProperty isFertilied = new SimpleBooleanProperty();
    private BooleanProperty hasGrass = new SimpleBooleanProperty();

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

    void setHasGrass(boolean hasGrass) {
        this.hasGrass.set(hasGrass);
    }

//    void plantGrass(){
//    }

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
}
