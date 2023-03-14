package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.List;

public class GameFacade {
    private final Game game = new Game();

    public IntegerProperty getDayProperty(){
        return game.getDayProperty();
    }

    public void increaseDayProperty() {
        game.increaseDayProperty();
    }

    public ObjectProperty<Mode> gameModeProperty() {
        return game.gameModeProperty();
    }

    public void setGameMode(Mode gameMode) {
        game.setGameMode(gameMode);
    }

    public ListProperty<Element> getParcelValueProperty(Position position) {
        return game.getParcelValueProperty(position);
    }

    public boolean containsElement(Position position, Element element) {
        return game.containsElement(position, element);
    }

    public void removeElement(Position position, ElementType element) {
        game.removeElement(position, element);
    }

    public void addElement(Position position, Element element) {
        game.addElement(position, element);
    }

    public List<Element> getParcelValue(Position position) {
        return game.getParcelValue(position);
    }

    public void setParcelValue(Position position, List<Element> element) {
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

    public void plantOrRemove() { // dans game model
        game.plantOrRemove();
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


    public BooleanProperty farmerMovementEnableProperty() {
        return game.farmerMovementEnableProperty();
    }

    public ReadOnlyIntegerProperty getScoreProperty() {
        return game.getScoreProperty();
    }

    public boolean containsCarrot(Position position) {
       return game.containsCarrot(position);
    }

    public void autoHarvest(Position position, ElementType elementType){
        game.autoHarvest(position,elementType);
    }

//    public StringProperty getCarrotImageProperty(Position position) {
//        return game.getCarrotImageProperty(position);
//    }
}
