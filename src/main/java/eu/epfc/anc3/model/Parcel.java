package eu.epfc.anc3.model;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.util.Iterator;
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

    public int autoHarvest(ElementType elementType){
        int res = 0;
        for(Element element : elements) {
            res = element.getHarvestScore().get();
        }
        removeElement(elementType);
        return res;
    }

    public int harvest(){
        int res = 0;
        boolean hasVegetables = false; // flag to check if there are any vegetables in the collection
        Iterator<Element> iterator = elements.iterator();
        while(iterator.hasNext()) {
            Element element = iterator.next();
            if(element.getType() == ElementType.CARROT){
                element.setElementHarvestScore();
                res = element.getHarvestScore().get();
                iterator.remove();
                hasVegetables = true;
                break;
            } else if(element.getType() == ElementType.CABBAGE){
                element.setElementHarvestScore();
                res = element.getHarvestScore().get();
                iterator.remove();
                hasVegetables = true;
                break;
            }
        }
        if(!hasVegetables) { // if there are no vegetables, remove the grass
            elements.removeIf(e -> e.getType() == ElementType.GRASS);
        }
        return res;

    }

    public void plant(Mode mode){
        if(mode == Mode.PLANT_CABBAGE && !containsElement(new Cabbage()) && !containsElement(new Carrot())){
            Cabbage cabbage = new Cabbage();
            if(containsElement(new Grass())){
                cabbage.setHasGrass(true);
            }
            elements.add(cabbage);
        }else if(mode == Mode.PLANT_CARROT && !containsElement(new Cabbage()) && !containsElement(new Carrot())){
            elements.add(new Carrot());
        }else if(mode == Mode.PLANT_GRASS && !containsElement(new Grass())){
            elements.add(new Grass());
            if(containsElement(new Cabbage())){
                for(Element element : elements) {
                    if(element.getType() == ElementType.CABBAGE){
                        element.setHasGrass(true);
                    }
                }
            }
        }
        PlaceGrassToLastPlace();
    }

    public void fertilize(){
        for(Element element : elements) {
            if(element.getType() == ElementType.CARROT){
                element.fertilize();
            }
        }
    }

    public void PlaceGrassToLastPlace(){
        for (int i = 0; i < elements.size() - 1; i++) {
            Element element = elements.get(i);
            if (element.getType() == ElementType.GRASS) {
                elements.remove(i);
                elements.add(element);
                break;
            }
        }
    }


}
