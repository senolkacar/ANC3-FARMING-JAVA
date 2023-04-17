package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.List;

class Game {
    private final Farm farm = new Farm();
    private final Farmer farmer = new Farmer();
    private final Day day = new Day();
    private final BooleanProperty farmerMovementEnable = new SimpleBooleanProperty(false);
    private final IntegerProperty scoreProperty = new SimpleIntegerProperty(0);
    private final ObjectProperty<Mode> gameMode = new SimpleObjectProperty<>(Mode.FREE);
    private Memento savedMemento;

    IntegerProperty getDayProperty(){
        return day.dayPropertyProperty();
    }

    void start(){
        farmer.setPosition(new Position(0, 0));
        farm.reset();
        gameMode.set(Mode.FREE);
        scoreProperty.setValue(0);
        farmerMovementEnable.set(false);
    }

    void reset() {
        this.start();
        day.resetDayProperty();
        farmerMovementEnable.set(true);
    }

    void increaseDayProperty() {
        day.increaseDayProperty();
        farm.incrementDay();
    }
    ObjectProperty<Mode> gameModeProperty() {
        return gameMode;
    }

    void setGameMode(Mode gameMode) {
        this.gameMode.set(gameMode);
    }

    void autoHarvest(Position position, ElementType elementType){
        scoreProperty.setValue(scoreProperty.getValue() + farm.autoHarvest(position, elementType));
    }
    ListProperty<Element> getParcelValueProperty(Position position) {
        return farm.valueProperty(position);
    }
    List<Element> getParcelValue(Position position) {
        return farm.getValue(position);
    }
    void removeElement(Position position, ElementType element) {
        farm.removeElement(position, element);
    }
    void addElement(Position position, Element element) {
        farm.addElement(position, element);
    }
    void setParcelValue(Position position, List<Element> element) {
        farm.setValue(position, element);
    }
    Position getFarmerPosition() {
        return farmer.getPosition();
    }
    void setFarmerPosition(Position position) {
        farmer.setPosition(position);
    }
    boolean isMovementEnabled() {
        return farmerMovementEnable.get();
    }
    void setMovementEnabled(boolean movementEnabled) {
        this.farmerMovementEnable.set(movementEnabled);
    }
    void plantOrRemove(){
        if (!isMovementEnabled())
            return;
        if(gameMode.get() == Mode.PLANT_GRASS || gameMode.get() == Mode.PLANT_CARROT || gameMode.get() == Mode.PLANT_CABBAGE) {
            farm.plant(getFarmerPosition(), gameMode.get());
        }else if(gameMode.get() == Mode.HARVEST){
            scoreProperty.setValue(scoreProperty.getValue() + farm.harvest(getFarmerPosition()));
        }else if(gameMode.get() == Mode.FERTILIZE){
            farm.fertilize(getFarmerPosition());
        }
    }
    void onMouseClicked(Position position) {
        if (isMovementEnabled()) {
            farmer.teleport(position,farm);
        }
    }
    void moveFarmerUp() {
        if(isMovementEnabled()){
            farmer.moveUp(farm);
        }
    }
    void moveFarmerLeft() {
        if(isMovementEnabled()){
            farmer.moveLeft(farm);
        }
    }
    void moveFarmerRight() {
        if(isMovementEnabled()){
            farmer.moveRight(farm);
        }
    }
    void moveFarmerDown() {
        if(isMovementEnabled()){
            farmer.moveDown(farm);
        }
    }
    BooleanProperty farmerMovementEnableProperty() {
        return farmerMovementEnable;
    }
    ReadOnlyIntegerProperty getScoreProperty() {
        return scoreProperty;
    }

    Memento createMemento() {
        return new Memento(new Farm(this.farm), new Farmer(this.farmer), new Day(this.day), this.farmerMovementEnable.get(),
                this.scoreProperty.get(), this.gameMode.get());
    }

    void setMemento(Memento memento) {
        this.farm.setFarm(memento.getFarm());
        this.farmer.setPosition(memento.getFarmer().getPosition());
        this.day.setDay(memento.getDay());
        this.farmerMovementEnable.set(memento.getFarmerMovementEnable());
        this.scoreProperty.set(memento.getScoreProperty());
        this.gameMode.set(memento.getGameMode());
    }

    public void save() {
        savedMemento = createMemento();
    }

    public void restore() {
        if (savedMemento != null) {
            setMemento(savedMemento);
        }
    }

}
