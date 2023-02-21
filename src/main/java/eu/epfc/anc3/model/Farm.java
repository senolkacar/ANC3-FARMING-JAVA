package eu.epfc.anc3.model;
import javafx.beans.property.ListProperty;
import java.util.ArrayList;
import java.util.List;

class Farm {
    public static final int FARM_WIDTH = 25;
    public static final int FARM_HEIGHT = 15;
    public static final int PADDING = 10;

    private final Farmer farmer = new Farmer();
    private final Dirt dirt = new Dirt();
    private final List<Element> elements = new ArrayList<>();

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

    public void setValue(Position position, List<Element> element) {
            farm[position.getY()][position.getX()].setElement(element);
    }

    public boolean containsElement(Position position, Element element) {
        return farm[position.getY()][position.getX()].containsElement(element);
    }

    public void removeElement(Position position, Element element) {
        farm[position.getY()][position.getX()].removeElement(element);
    }

    public void addElement(Position position, Element element) {
        farm[position.getY()][position.getX()].addElement(element);
    }

    public void reset() {
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            for (int j = 0; j < FARM_WIDTH; ++j) {
               if(i==0&&j==0){
                   elements.add(farmer);
                   farm[i][j].setElement(elements);
               }else{
                   elements.clear();
                   elements.add(dirt);
                   farm[i][j].setElement(elements);
               }
            }
        }
    }

}
