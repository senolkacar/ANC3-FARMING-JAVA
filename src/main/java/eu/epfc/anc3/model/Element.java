package eu.epfc.anc3.model;

import java.util.Objects;

public abstract class Element  {

    ElementType elementType;
    private int state;

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


    public void incrementDay() {
    }

    public int getState() {
        return state;
    }
}
