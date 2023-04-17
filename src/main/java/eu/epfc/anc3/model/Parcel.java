package eu.epfc.anc3.model;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.util.Iterator;
import java.util.List;

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

    boolean containsElementType(ElementType elementType) {
        return elements.stream().anyMatch(element -> element.elementType ==elementType );
    }

    void incrementDay() {
//         elements.forEach(Element::incrementDay);//cause runtime exception when remove element
        ObservableList<Element> list = this.elements.get();
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getState() != null)
                list.get(i).getState().incrementDay();
        }
    }

    int autoHarvest(ElementType elementType){
        int res = 0;
        for(Element element : elements) {
            if(element.elementType == elementType && element.getState()!=null) {
                element.getState().setHarvestScore();
                res = element.getState().getHarvestScore().get();
                break;
            }
        }
        removeElement(elementType);
        return res;
    }

    int harvest(){
        int res = 0;
        boolean hasVegetables = false; // flag to check if there are any vegetables in the collection
        Iterator<Element> iterator = elements.iterator();
        while(iterator.hasNext()) {
            Element element = iterator.next();
            if(element.getIsVegetable() && element.getState()!=null){
                element.getState().setHarvestScore();
                res = element.getState().getHarvestScore().get();
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
    void plant(Mode mode){
        if(mode == Mode.PLANT_CABBAGE && !containsElementType(ElementType.CABBAGE) && !containsElementType(ElementType.CARROT)){
            //Cabbage cabbage = new Cabbage();
            elements.add(new Cabbage());
            if(containsElementType(ElementType.GRASS)){
                this.setHasGrass(true);
            }

        }else if(mode == Mode.PLANT_CARROT && !containsElementType(ElementType.CABBAGE) && !containsElementType(ElementType.CARROT)){
            elements.add(new Carrot());
        }else if(mode == Mode.PLANT_GRASS && !containsElementType(ElementType.GRASS)){
            elements.add(new Grass());
            this.setHasGrass(true);
        }
        PlaceGrassToLastPlace();

    }

    void fertilize(){
        for(Element element : elements) {
            if(element.getType() == ElementType.CARROT && element.getState()!=null){
                element.getState().fertilize();
            }
        }
    }
    void setHasGrass(boolean hasGrass) {
        for (Element element : elements) {
            element.setHasGrass(hasGrass);
        }
    }
    void PlaceGrassToLastPlace(){
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
