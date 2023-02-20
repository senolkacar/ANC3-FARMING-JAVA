package eu.epfc.anc3.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SetProperty;

import java.util.List;
import java.util.Set;

public class GameFacade {
    private final Game game = new Game();

    public ObjectProperty<Mode> gameModeProperty() {
        return game.gameModeProperty();
    }

    public void setGameMode(Mode gameMode) {
        game.setGameMode(gameMode);
    }

    public SetProperty<Element> getParcelValueProperty(Position position) {
        return game.getParcelValueProperty(position);
    }

    public boolean containsElement(Position position, Element element) {
        return game.containsElement(position, element);
    }

    public void removeElement(Position position, Element element) {
        game.removeElement(position, element);
    }

    public void addElement(Position position, Element element) {
        game.addElement(position, element);
    }

    public Set<Element> getParcelValue(Position position) {
        return game.getParcelValue(position);
    }

    public void setParcelValue(Position position, Set<Element> element) {
        game.setParcelValue(position, element);
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

    public static int getFarmWidth(){
        return Farm.FARM_WIDTH;
    }

    public static int getFarmHeight(){
        return Farm.FARM_HEIGHT;
    }

    public static int getPadding(){
        return Farm.PADDING;
    }

    public void plantOrRemoveGrass() { // dans game model
        game.plantOrRemoveGrass();
    }

    public void onMouseClicked(Position position) {
        game.onMouseClicked(position);
    }

    public void moveFarmerUp() {
        game.moveFarmerUp();
    }

    public void moveFarmerLeft() {
       game.moveFarmerLeft();
    }

    public void moveFarmerRight() {
        game.moveFarmerRight();
    }

    public void moveFarmerDown() {
       game.moveFarmerDown();
    }




}
