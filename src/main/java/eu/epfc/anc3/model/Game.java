package eu.epfc.anc3.model;

import javafx.beans.property.ReadOnlyObjectProperty;

public class Game {
    private Farm farm;
    ReadOnlyObjectProperty<ParcelValue> valueProperty(int line, int col) {
        return farm.valueProperty(line, col);
    }
}
