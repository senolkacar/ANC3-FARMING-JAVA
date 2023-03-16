package eu.epfc.anc3.model;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

import static javafx.collections.FXCollections.observableArrayList;

class Parcel {

    private final SimpleListProperty<Element> elements = new SimpleListProperty<>(observableArrayList(new Dirt()));

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

    void removeElement(ElementType oldElement){
        this.elements.removeIf(e->e.getType()==oldElement);
    }

    boolean containsElement(Element newElement) {
        return elements.contains(newElement);
    }

    public void incrementDay() {
//         elements.forEach(Element::incrementDay);//cause runtime exception when remove element
        ObservableList<Element> list = this.elements.get();
        for (int i=0; i<list.size(); i++) {
            list.get(i).incrementDay();
        }
    }



}
