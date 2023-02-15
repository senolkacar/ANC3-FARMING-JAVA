package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

public class Farm {
    public static final int FARM_WIDTH = 25;
    public static final int FARM_HEIGHT = 15;

    public static final int PADDING = 10;

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

    ObjectProperty<Element> valueProperty(Position position) {
        return farm[position.getY()][position.getX()].valueProperty();
    }

    Element getValue(Position position) {
        return farm[position.getY()][position.getX()].getValue();
    }

    public boolean setValue(Position position, Element value) {
        return farm[position.getY()][position.getX()].setValue(value);
    }

    public void reset() {
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            for (int j = 0; j < FARM_WIDTH; ++j) {
                farm[i][j].setValue(i == 0 && j == 0
                        ? new Element(Type.DIRT_AND_FARMER)
                        : new Element(Type.DIRT));


            }
        }
    }

}
