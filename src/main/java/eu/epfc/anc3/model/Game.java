package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.List;
import java.util.Set;

class Game {
    private Farm farm = new Farm();
    private Dirt dirt = new Dirt();
    private Grass grass = new Grass();
    private Farmer farmer = new Farmer();
    private boolean movementEnabled = false;
    //private Mode mode = Mode.FREE;


    private final IntegerProperty grassParcelCount = new SimpleIntegerProperty(0);
    private final ObjectProperty<Mode> gameMode = new SimpleObjectProperty<>(Mode.FREE);

    ObjectProperty<Mode> gameModeProperty() {
        return gameMode;
    }

    public void setGameMode(Mode gameMode) {
        this.gameMode.set(gameMode);
    }

    public ListProperty<Element> getParcelValueProperty(Position position) {
        return farm.valueProperty(position);
    }

    public List<Element> getParcelValue(Position position) {
        return farm.getValue(position);
    }

    public boolean containsElement(Position position, Element element) {
        return farm.containsElement(position, element);
    }

    public void removeElement(Position position, Element element) {
        farm.removeElement(position, element);
    }

    public void addElement(Position position, Element element) {
        farm.addElement(position, element);
    }

    public void setParcelValue(Position position, List<Element> element) {
        farm.setValue(position, element);
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

    public ReadOnlyIntegerProperty getGrassParcelCountValueProperty() {
        return grassParcelCount;
    }

    public void increaseGrassParcelCount() {
        grassParcelCount.setValue(grassParcelCount.getValue() + 1);
    }

    public void decreaseGrassParcelCount() {
        if (grassParcelCount.getValue()>0) {
            grassParcelCount.setValue(grassParcelCount.getValue() - 1);
        }
    }

    public void start(){
        farmer.setPosition(new Position(0, 0));
        farm.reset();
        gameMode.set(Mode.FREE);
        //mode = Mode.FREE;
        grassParcelCount.setValue(0);
        movementEnabled = false;
    }

    public void reset() {
        this.start();
        movementEnabled = true;
    }

    public void plantOrRemoveGrass() { // dans game model
        if (!isMovementEnabled())
            return;

        if(gameMode.get() == Mode.PLANT&& !this.containsElement(getFarmerPosition(), grass)) {
                this.addElement(getFarmerPosition(), grass);
//                this.addElement(getFarmerPosition(), farmer);
//                this.removeElement(getFarmerPosition(), farmer);////should add remove farmer in order to show farmer in the top of grass
//                this.removeElement(getFarmerPosition(), dirt);
                increaseGrassParcelCount();
            }
        else if (gameMode.get() == Mode.REMOVE && !this.containsElement(getFarmerPosition(), dirt)) {
                this.addElement(getFarmerPosition(), dirt);
//                this.addElement(getFarmerPosition(), farmer);
//                this.removeElement(getFarmerPosition(), farmer);//should add remove farmer in order to show farmer in the top of dirt
//                this.removeElement(getFarmerPosition(), grass);
                decreaseGrassParcelCount();
        }
    }

    public void onMouseClicked(Position position) {
        if (isMovementEnabled()) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(position);
            this.addElement(getFarmerPosition(), farmer);
        }
    }

    public void moveFarmerUp() {
        if (isMovementEnabled() && getFarmerPosition().getY() > 0) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX(),getFarmerPosition().getY()-1));
            this.addElement(getFarmerPosition(), farmer);
        }
    }

    public void moveFarmerLeft() {
        if (isMovementEnabled() && getFarmerPosition().getX() > 0) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX()-1,getFarmerPosition().getY()));
            this.addElement(getFarmerPosition(), farmer);
        }
    }

    public void moveFarmerRight() {
        if (isMovementEnabled() && getFarmerPosition().getX() < Farm.FARM_WIDTH - 1) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX()+1,getFarmerPosition().getY()));
            this.addElement(getFarmerPosition(), farmer);
        }
    }

    public void moveFarmerDown() {
        if (isMovementEnabled() && getFarmerPosition().getY() < Farm.FARM_HEIGHT - 1) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX(),getFarmerPosition().getY()+1));
            this.addElement(getFarmerPosition(), farmer);
        }
    }


}
