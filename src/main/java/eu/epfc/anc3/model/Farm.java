package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

public class Farm {
    public static final int FARM_WIDTH = 15;
    public static final int FARM_HEIGHT = 25;

    private final Parcel[][] grid;

    Farm() {
        grid = new Parcel[FARM_HEIGHT][];
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            grid[i] = new Parcel[FARM_WIDTH];
            for (int j = 0; j < FARM_WIDTH; ++j) {
                grid[i][j] = new Parcel();
            }
        }
    }

    ObjectProperty<ElementValue> valueProperty(int[] position) {
        return grid[position[0]][position[1]].valueProperty();
    }

    ElementValue getValue(int[] position) {
        return grid[position[0]][position[1]].getValue();
    }

    public boolean setValue(int[] position, ElementValue value) {
        return grid[position[0]][position[1]].setValue(value);
    }

    public void reset() {
        for (int i = 0; i < FARM_HEIGHT; ++i) {
            for (int j = 0; j < FARM_WIDTH; ++j) {
                grid[i][j].setValue(i == 0 && j == 0
                        ? ElementValue.DIRT_AND_FARMER
                        : ElementValue.DIRT);


            }
        }
    }
}
