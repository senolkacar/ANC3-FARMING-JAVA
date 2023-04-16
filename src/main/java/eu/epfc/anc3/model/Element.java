package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.Objects;

public abstract class Element  {

    public ElementType elementType;
    public  ObjectProperty<State> state = new SimpleObjectProperty<>();
//    private BooleanProperty isFertilied = new SimpleBooleanProperty(false);
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

//    void incrementDay() {
//    }

    @Override
    public String toString(){
        return elementType.toString()  ;
    }

//    void setIsFertilied(boolean isFertilied) {
//        this.isFertilied.set(isFertilied);
//    }
//
//    void fertilize(){
//    }

//


//    IntegerProperty getHarvestScore(){
//        return new SimpleIntegerProperty();
//    }
//
//    void setElementHarvestScore(){}


    public boolean hasGrass() {
        return hasGrass.get();
    }

    public BooleanProperty hasGrassProperty() {
        return hasGrass;
    }

    public void setHasGrass(boolean hasGrass) {
        this.hasGrass.set(hasGrass);
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
