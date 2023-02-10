package eu.epfc.anc3.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Farmer {
    private Position position;
    private final IntegerProperty gazonScore = new SimpleIntegerProperty(0);

    public Farmer() {
        position = new Position(0, 0);
        gazonScore.addListener((src, oldValue, newValue) -> {
            gazonScore.setValue(newValue.intValue());
        });
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    IntegerProperty gazonScoreProperty() {
        return gazonScore;
    }
}
