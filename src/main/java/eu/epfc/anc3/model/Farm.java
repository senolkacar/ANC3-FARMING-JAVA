package eu.epfc.anc3.model;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

class Farm {
    public static final int FARM_WIDTH = 25;
    public static final int FARM_HEIGHT = 15;
    public static final int PADDING = 10;

//    private final Farmer farmer = new Farmer();
//    private final Dirt dirt = new Dirt();
//    private final List<Element> elements = new ArrayList<>();

    private final Parcel[][] farm;

    Farm() {
        farm = new Parcel[FARM_HEIGHT][];
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            farm[i] = new Parcel[FARM_WIDTH];
            for (int j = 0; j < FARM_WIDTH; ++j) {
                farm[i][j] = new Parcel();
            }
        }
    }

    ListProperty<Element> valueProperty(Position position) {
        return farm[position.getY()][position.getX()].elementProperty();
    }

    List<Element> getValue(Position position) {
        return farm[position.getY()][position.getX()].getValue();
    }

    void setValue(Position position, List<Element> element) {
            farm[position.getY()][position.getX()].setElement(element);
    }

    boolean containsElement(Position position, Element element) {
        return farm[position.getY()][position.getX()].containsElement(element);
    }

    void removeElement(Position position, ElementType element) {
        farm[position.getY()][position.getX()].removeElement(element);
    }

    void addElement(Position position, Element element) {
        farm[position.getY()][position.getX()].addElement(element);
    }

//    void setCarrotImage(Position position) {
//        farm[position.getY()][position.getX()].setCarrotImage();
//    }
//    String getCarrotImage(Position position) {
//        return farm[position.getY()][position.getX()].getCarrotImage();
//    }
//
//    StringProperty getCarrotImageProperty(Position position) {
//        return farm[position.getY()][position.getX()].getCarrotImageProperty();
//
//    }

    public ObjectProperty<ImageType> getImageProperty(Position position) {
        return farm[position.getY()][position.getX()].getImageProperty();
    }

    void reset() {
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            for (int j = 0; j < FARM_WIDTH; ++j) {
                farm[i][j].clearElements();
                farm[i][j].addElement(new Dirt());
//                farm[i][j].setCarrotImageProperty();
               if(i==0&&j==0){
                   farm[i][j].addElement(new Farmer());
               }
            }
        }
    }

    void incrementDay() {
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            for (int j = 0; j < FARM_WIDTH; ++j) {
                farm[i][j].incrementDay();

            }
        }
    }



}
