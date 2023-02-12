package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Game {
    private Farm farm = new Farm();
    private Farmer farmer = new Farmer();
    private boolean movementEnabled = false;
    private Mode mode = Mode.FREE;
    private final ObjectProperty<Integer> grassParcelCount = new SimpleObjectProperty<>(0);

    public ObjectProperty<ParcelValue> getParcelValueProperty(int[] position) {
        return farm.valueProperty(position);
    }

    public ParcelValue getParcelValue(int[] position) {
        return farm.getValue(position);
    }

    public void setParcelValue(int[] position, ParcelValue value) {
        farm.setValue(position, value);
    }

    public int[] getFarmerPosition() {
        return farmer.getPosition();
    }

    public void setFarmerPosition(int[] position) {
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

    public ReadOnlyObjectProperty<Integer> getGrassParcelCountValueProperty() {
        return grassParcelCount;
    }

    public void increaseGrassParcelCount() {
        grassParcelCount.setValue(grassParcelCount.getValue() + 1);
    }

    public void decreaseGrassParcelCount() {
        grassParcelCount.setValue(grassParcelCount.getValue() - 1);
    }

    public void reset() {
        farmer.setPosition(new int[]{0, 0});
        farm.reset();
        movementEnabled = true;
        mode = Mode.FREE;
        grassParcelCount.setValue(0);
    }
}
