package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.Objects;

public abstract class Element  {
    ElementType elementType;
    private ObjectProperty<State> state = new SimpleObjectProperty<>();
    private final BooleanProperty hasGrass = new SimpleBooleanProperty();
    private final BooleanProperty isVegetable = new SimpleBooleanProperty(false);
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
    @Override
    public String toString(){
        return elementType.toString()  ;
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
    boolean getIsVegetable() {
        return isVegetable.get();
    }
    BooleanProperty getIsVegetableProperty() {
        return isVegetable;
    }
    void setIsVegetable(boolean isVegetable) {
        this.isVegetable.set(isVegetable);
    }
    public State getState() {
        return state.get();
    }
    public ObjectProperty<State> stateProperty() {
        return state;
    }

    public abstract Element getCopy();


}
