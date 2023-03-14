package eu.epfc.anc3.model;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

import static javafx.collections.FXCollections.observableArrayList;

class Parcel {
//    private String carrotImageString = this.setCarrotImage();
//    private StringProperty carrotImage = new SimpleStringProperty(carrotImageString);

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



//    Element getCarrot(){
//       return elements.get().filtered(element -> element.getType()==ElementType.CARROT).stream().findFirst().orElse(null);
//        //return (Carrot) elements.stream().filter(e->e instanceof Carrot).findFirst().orElse(null);
//    }
//
//    Cabbage getCabbage(){
//
//        return (Cabbage) elements.stream().filter(e->e instanceof Cabbage).findFirst().orElse(null);
//    }
//
//    public String setCarrotImage() {//getter
//        if (elements != null){
//            List<Element> newList = elements.stream().filter(e->e.elementType==ElementType.CARROT).limit(1).collect(Collectors.toList());
//            if (newList.size()>0)
//                return newList.get(0).getImage();
//            else
//                return "";
//
//        }
//
//        return "";
//    }
//
//    public void setCarrotImageProperty() {
//        carrotImage.set(setCarrotImage());
//    }
//
//    public String getCarrotImage() {
//        return carrotImage.get();
//    }
//
//    public StringProperty getCarrotImageProperty() {
//        return carrotImage;
//    }
//
//    public void setCarrotImage(String carrotImage) {
//        this.carrotImage.set(carrotImage);
//    }


}
