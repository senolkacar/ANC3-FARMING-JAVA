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

    public void plantOrRemoveGrass() { // dans game model
        if (!game.isMovementEnabled())
            return;

        ElementValue elementValueAtFarmerPosition = game.getParcelValue(game.getFarmerPosition());
        if (game.getMode() == Mode.PLANT && elementValueAtFarmerPosition == ElementValue.DIRT_AND_FARMER) {
            game.setParcelValue(game.getFarmerPosition(), ElementValue.GRASS_AND_FARMER);
            game.increaseGrassParcelCount();
        } else if (game.getMode() == Mode.REMOVE && elementValueAtFarmerPosition == ElementValue.GRASS_AND_FARMER) {
            game.setParcelValue(game.getFarmerPosition(), ElementValue.DIRT_AND_FARMER);
            game.decreaseGrassParcelCount();
        }
    }

    public void onMouseClicked(Position position) {
        if (game.isMovementEnabled()) {
            ElementValue newValueOfParcelWithFarmer = game.getParcelValue(game.getFarmerPosition()) == ElementValue.DIRT_AND_FARMER ? ElementValue.DIRT : ElementValue.GRASS;
            game.setParcelValue(game.getFarmerPosition(), newValueOfParcelWithFarmer);

            game.setFarmerPosition(position);

            ElementValue newValueOfParcelWithoutFarmer = game.getParcelValue(game.getFarmerPosition()) == ElementValue.DIRT ? ElementValue.DIRT_AND_FARMER : ElementValue.GRASS_AND_FARMER;
            game.setParcelValue(game.getFarmerPosition(), newValueOfParcelWithoutFarmer);
        }
    }

    public void moveFarmerUp() {
        if (game.isMovementEnabled() && game.getFarmerPosition().getY() > 0) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new Position(game.getFarmerPosition().getX(),game.getFarmerPosition().getY()-1));
            this.putFarmerOnParcel();
        }
    }

    public void moverFarmerLeft() {
        if (game.isMovementEnabled() && game.getFarmerPosition().getX() > 0) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new Position(game.getFarmerPosition().getX()-1,game.getFarmerPosition().getY()));
            this.putFarmerOnParcel();
        }
    }

    public void moveFarmerRight() {
        if (game.isMovementEnabled() && game.getFarmerPosition().getX() < Farm.FARM_WIDTH - 1) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new Position(game.getFarmerPosition().getX()+1,game.getFarmerPosition().getY()));
            this.putFarmerOnParcel();
        }
    }

    public void moveFarmerDown() {
        if (game.isMovementEnabled() && game.getFarmerPosition().getY() < Farm.FARM_HEIGHT - 1) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new Position(game.getFarmerPosition().getX(),game.getFarmerPosition().getY()+1));
            this.putFarmerOnParcel();
        }
    }

    private void removeFarmerFromParcel() {
        ElementValue elementValueAtFarmerPosition = game.getParcelValue(game.getFarmerPosition());
        game.setParcelValue(game.getFarmerPosition(), elementValueAtFarmerPosition == ElementValue.DIRT_AND_FARMER ? ElementValue.DIRT : ElementValue.GRASS);
    }

    private void putFarmerOnParcel() {
        ElementValue elementValueAtNewFarmerPosition = game.getParcelValue(game.getFarmerPosition());
        game.setParcelValue(game.getFarmerPosition(), elementValueAtNewFarmerPosition == ElementValue.DIRT ? ElementValue.DIRT_AND_FARMER : ElementValue.GRASS_AND_FARMER);
    }


}
