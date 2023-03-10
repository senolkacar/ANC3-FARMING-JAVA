package eu.epfc.anc3.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public abstract class Element  {

   public ElementType elementType;
    private StringProperty image = new SimpleStringProperty("");
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

    @Override
    public String toString(){
        return elementType.toString();
    }

    public String getImage() {
        return image.get();
    }

    public StringProperty imageProperty() {
        return image;
    }
}
