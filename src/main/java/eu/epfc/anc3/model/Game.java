package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.List;
import java.util.Set;

class Game {
    private final Farm farm = new Farm();
    private final Dirt dirt = new Dirt();
    private final Grass grass = new Grass();
    private final Farmer farmer = new Farmer();
    private final Day day = new Day();
    private boolean movementEnabled = false;

    private final IntegerProperty grassParcelCount = new SimpleIntegerProperty(0);
    private final ObjectProperty<Mode> gameMode = new SimpleObjectProperty<>(Mode.FREE);

    IntegerProperty getDayProperty(){
        return day.dayPropertyProperty();
    }

    void increaseDayProperty() {
        day.increaseDayProperty();
    }

    ObjectProperty<Mode> gameModeProperty() {
        return gameMode;
    }

    void setGameMode(Mode gameMode) {
        this.gameMode.set(gameMode);
    }

    ListProperty<Element> getParcelValueProperty(Position position) {
        return farm.valueProperty(position);
    }

    List<Element> getParcelValue(Position position) {
        return farm.getValue(position);
    }

    boolean containsElement(Position position, Element element) {
        return farm.containsElement(position, element);
    }

    void removeElement(Position position, Element element) {
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
        return movementEnabled;
    }

    void setMovementEnabled(boolean movementEnabled) {
        this.movementEnabled = movementEnabled;
    }

    ReadOnlyIntegerProperty getGrassParcelCountValueProperty() {
        return grassParcelCount;
    }

    void increaseGrassParcelCount() {
        grassParcelCount.setValue(grassParcelCount.getValue() + 1);
    }

    void decreaseGrassParcelCount() {
        if (grassParcelCount.getValue()>0) {
            grassParcelCount.setValue(grassParcelCount.getValue() - 1);
        }
    }

    void start(){
        farmer.setPosition(new Position(0, 0));
        farm.reset();
        gameMode.set(Mode.FREE);
        //mode = Mode.FREE;
        grassParcelCount.setValue(0);
        movementEnabled = false;
    }

    void reset() {
        this.start();
        day.resetDayProperty();
        movementEnabled = true;
    }

    void plantOrRemoveGrass() {
        if (!isMovementEnabled())
            return;

        if(gameMode.get() == Mode.PLANT&& !this.containsElement(getFarmerPosition(), grass)) {
                this.removeElement(getFarmerPosition(), dirt);
                this.addElement(getFarmerPosition(), grass);
                increaseGrassParcelCount();
            }
        else if (gameMode.get() == Mode.REMOVE && this.containsElement(getFarmerPosition(), grass)) {
                this.removeElement(getFarmerPosition(), grass);
                this.addElement(getFarmerPosition(), dirt);
                decreaseGrassParcelCount();
        }
    }

    void onMouseClicked(Position position) {
        if (isMovementEnabled()) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(position);
            this.addElement(getFarmerPosition(), farmer);
        }
    }

    void moveFarmerUp() {
        if (isMovementEnabled() && getFarmerPosition().getY() > 0) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX(),getFarmerPosition().getY()-1));
            this.addElement(getFarmerPosition(), farmer);
        }
    }

    void moveFarmerLeft() {
        if (isMovementEnabled() && getFarmerPosition().getX() > 0) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX()-1,getFarmerPosition().getY()));
            this.addElement(getFarmerPosition(), farmer);
        }
    }

    void moveFarmerRight() {
        if (isMovementEnabled() && getFarmerPosition().getX() < Farm.FARM_WIDTH - 1) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX()+1,getFarmerPosition().getY()));
            this.addElement(getFarmerPosition(), farmer);
        }
    }

    void moveFarmerDown() {
        if (isMovementEnabled() && getFarmerPosition().getY() < Farm.FARM_HEIGHT - 1) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX(),getFarmerPosition().getY()+1));
            this.addElement(getFarmerPosition(), farmer);
        }
    }


}
