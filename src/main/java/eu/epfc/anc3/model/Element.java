package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.ImageView;

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
}
