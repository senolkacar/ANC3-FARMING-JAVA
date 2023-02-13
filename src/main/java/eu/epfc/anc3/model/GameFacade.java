package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;

public class GameFacade {
    private final Game game = new Game();

    public ObjectProperty<ElementValue> getParcelValueProperty(Position position) {
        return game.getParcelValueProperty(position);
    }

    public ElementValue getParcelValue(Position position) {
        return game.getParcelValue(position);
    }

    public void setParcelValue(Position position, ElementValue value) {
        game.setParcelValue(position, value);
    }

    public Position getFarmerPosition() {
        return game.getFarmerPosition();
    }

    public void setFarmerPosition(Position position) {
        game.setFarmerPosition(position);
    }

    public boolean isMovementEnabled() {
        return game.isMovementEnabled();
    }

    public void setMovementEnabled(boolean movementEnabled) {
        game.setMovementEnabled(movementEnabled);
    }

    public Mode getMode() {
        return game.getMode();
    }

    public void setMode(Mode mode) {
        game.setMode(mode);
    }

    public ReadOnlyIntegerProperty getGrassParcelCountValueProperty() {
        return game.getGrassParcelCountValueProperty();
    }

    public void increaseGrassParcelCount() {
        game.increaseGrassParcelCount();
    }

    public void decreaseGrassParcelCount() {
        game.decreaseGrassParcelCount();
    }

    public void start() {
        game.start();
    }
    public void reset() {
        game.reset();
    }
}
