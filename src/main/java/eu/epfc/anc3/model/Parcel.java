package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

class Parcel {


    private SimpleListProperty<Element> elements = new SimpleListProperty<>(observableArrayList(new Dirt()));

    SimpleListProperty<Element> elementProperty() {
        return elements;
    }

    void addElement(Element newElement){
        this.elements.add(newElement);
    }

    void setElement(List<Element> newElement){
      this.elements.setAll(newElement);
    }

    void clearElements(){
        elements.clear();
    }

    List<Element> getValue() {
        return elements.getValue();
    }

    void removeElement(Element oldElement){
        this.elements.removeIf(e->e.equals(oldElement));
    }

    boolean containsElement(Element newElement) {
        return elements.contains(newElement);
    }

    void incrementDay(){
        elements.forEach(Element::incrementDay);
    }

    Carrot getCarrot(){
        return (Carrot) elements.stream().filter(e->e instanceof Carrot).findFirst().orElse(null);
    }

    Cabbage getCabbage(){
        return (Cabbage) elements.stream().filter(e->e instanceof Cabbage).findFirst().orElse(null);
    }


}
