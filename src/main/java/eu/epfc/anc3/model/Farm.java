package eu.epfc.anc3.model;

import javafx.beans.property.ListProperty;

import java.util.List;

class Farm {
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

    Farm(Farm other) {
        farm = new Parcel[FARM_HEIGHT][FARM_WIDTH];
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            for (int j = 0; j < FARM_WIDTH; ++j) {
                farm[i][j] = new Parcel(other.farm[i][j]);
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

    boolean containsElementType(Position position, ElementType elementType) {
        return farm[position.getY()][position.getX()].containsElementType(elementType);
    }

    void removeElement(Position position, ElementType element) {
        farm[position.getY()][position.getX()].removeElement(element);
    }

    void addElement(Position position, Element element) {
        farm[position.getY()][position.getX()].addElement(element);
    }

    int autoHarvest(Position position, ElementType elementType) {
        return farm[position.getY()][position.getX()].autoHarvest(elementType);
    }

    int harvest(Position position) {
        return farm[position.getY()][position.getX()].harvest();
    }

    void plant(Position position, Mode mode) {
        farm[position.getY()][position.getX()].plant(mode);
    }

    void fertilize(Position position) {
        farm[position.getY()][position.getX()].fertilize();
    }

    void reset() {
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            for (int j = 0; j < FARM_WIDTH; ++j) {
                farm[i][j].clearElements();
                farm[i][j].addElement(new Dirt());
                if (i == 0 && j == 0) {
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

    void setFarm(Farm farm) {
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            for (int j = 0; j < FARM_WIDTH; ++j) {
                this.farm[i][j].setElement(farm.farm[i][j].getValue());
            }
        }
    }
}
