package eu.epfc.anc3.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.util.List;
import java.util.Set;

import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableSet;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

class Parcel {


    SimpleSetProperty<Element> elements = new SimpleSetProperty<>(FXCollections.observableSet(new Dirt()));//new Dirt()

    SimpleSetProperty<Element> elementProperty() {
        return elements;
    }

    public void addElement(Element newElement){
        this.elements.add(newElement);
    }

    public void setElement(Set<Element> newElement){
        ObservableSet<Element> observableNewElements = FXCollections.observableSet(newElement);
        this.elements.set(observableNewElements);
    }

    public void clearElements(){
        elements.clear();
    }

    Set<Element> getValue() {
        return elements.getValue();
    }

    public void removeElement(Element oldElement){
        this.elements.remove(oldElement);
    }

    public boolean containsElement(Element newElement) {
        return elements.contains(newElement);
    }
}
