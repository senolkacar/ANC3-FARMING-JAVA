package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.ImageView;

import java.util.Objects;

public abstract class Element implements Comparable<Element> {
    Type type;
    public Type getType() {
        return type;
    }


    public int compareTo(Element el){
        return this.toString().compareTo(el.toString());

    }

    @Override
    public String toString(){
        return type.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return getType() == element.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
