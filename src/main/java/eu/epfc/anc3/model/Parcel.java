package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

class Parcel {


    SimpleListProperty<Element> elements = new SimpleListProperty<>(observableArrayList(new Dirt()));

    SimpleListProperty<Element> elementProperty() {
        return elements;
    }

    public void addElement(Element newElement){
        this.elements.add(newElement);
    }

    public void setElement(List<Element> newElement){
      this.elements.setAll(newElement);
    }

    public void clearElements(){
        elements.clear();
    }

    List<Element> getValue() {
        return elements.getValue();
    }

    public void removeElement(Element oldElement){
        this.elements.remove(oldElement);
    }

    public boolean containsElement(Element newElement) {
        return elements.contains(newElement);
    }
}
