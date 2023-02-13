package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class Game {
    private Farm farm = new Farm();
    private Farmer farmer = new Farmer();
    private boolean movementEnabled = false;
    private Mode mode = Mode.FREE;
    private final IntegerProperty grassParcelCount = new SimpleIntegerProperty(0);

    public ObjectProperty<ElementValue> getParcelValueProperty(Position position) {
        return farm.valueProperty(position);
    }

    public ElementValue getParcelValue(Position position) {
        return farm.getValue(position);
    }

    public void setParcelValue(Position position, ElementValue value) {
        farm.setValue(position, value);
    }

    public Position getFarmerPosition() {
        return farmer.getPosition();
    }

    public void setFarmerPosition(Position position) {
        farmer.setPosition(position);
    }

    public boolean isMovementEnabled() {
        return movementEnabled;
    }

    public void setMovementEnabled(boolean movementEnabled) {
        this.movementEnabled = movementEnabled;
    }

    public Mode getMode() {
        return this.mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public ReadOnlyIntegerProperty getGrassParcelCountValueProperty() {
        return grassParcelCount;
    }

    public void increaseGrassParcelCount() {
        grassParcelCount.setValue(grassParcelCount.getValue() + 1);
    }

    public void decreaseGrassParcelCount() {
        grassParcelCount.setValue(grassParcelCount.getValue() - 1);
    }

    public void start(){
        farmer.setPosition(new Position(0, 0));
        farm.reset();
        movementEnabled = false;
        mode = Mode.FREE;//
        grassParcelCount.setValue(0);

    }

    public void reset() {
        farmer.setPosition(new Position(0, 0));
        farm.reset();
        movementEnabled = true;//?
        mode = Mode.FREE;//
        grassParcelCount.setValue(0);
    }
}
