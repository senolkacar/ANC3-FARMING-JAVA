package eu.epfc.anc3.model;

import javafx.beans.property.*;

class Game {
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
        mode = Mode.FREE;
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

        ElementValue elementValueAtFarmerPosition = getParcelValue(getFarmerPosition());
        if (getMode() == Mode.PLANT && elementValueAtFarmerPosition == ElementValue.DIRT_AND_FARMER) {
            setParcelValue(getFarmerPosition(), ElementValue.GRASS_AND_FARMER);
            increaseGrassParcelCount();
        } else if (getMode() == Mode.REMOVE && elementValueAtFarmerPosition == ElementValue.GRASS_AND_FARMER) {
            setParcelValue(getFarmerPosition(), ElementValue.DIRT_AND_FARMER);
            decreaseGrassParcelCount();
        }
    }

    public void onMouseClicked(Position position) {
        if (isMovementEnabled()) {
            ElementValue newValueOfParcelWithFarmer = getParcelValue(getFarmerPosition()) == ElementValue.DIRT_AND_FARMER ? ElementValue.DIRT : ElementValue.GRASS;
            setParcelValue(getFarmerPosition(), newValueOfParcelWithFarmer);

            setFarmerPosition(position);

            ElementValue newValueOfParcelWithoutFarmer = getParcelValue(getFarmerPosition()) == ElementValue.DIRT ? ElementValue.DIRT_AND_FARMER : ElementValue.GRASS_AND_FARMER;
            setParcelValue(getFarmerPosition(), newValueOfParcelWithoutFarmer);
        }
    }

    public void moveFarmerUp() {
        if (isMovementEnabled() && getFarmerPosition().getY() > 0) {
            removeFarmerFromParcel();
            setFarmerPosition(new Position(getFarmerPosition().getX(),getFarmerPosition().getY()-1));
            putFarmerOnParcel();
        }
    }

    public void moveFarmerLeft() {
        if (isMovementEnabled() && getFarmerPosition().getX() > 0) {
            this.removeFarmerFromParcel();
            setFarmerPosition(new Position(getFarmerPosition().getX()-1,getFarmerPosition().getY()));
            this.putFarmerOnParcel();
        }
    }

    public void moveFarmerRight() {
        if (isMovementEnabled() && getFarmerPosition().getX() < Farm.FARM_WIDTH - 1) {
            this.removeFarmerFromParcel();
            setFarmerPosition(new Position(getFarmerPosition().getX()+1,getFarmerPosition().getY()));
            this.putFarmerOnParcel();
        }
    }

    public void moveFarmerDown() {
        if (isMovementEnabled() && getFarmerPosition().getY() < Farm.FARM_HEIGHT - 1) {
            this.removeFarmerFromParcel();
            setFarmerPosition(new Position(getFarmerPosition().getX(),getFarmerPosition().getY()+1));
            this.putFarmerOnParcel();
        }
    }

    void removeFarmerFromParcel() {
        ElementValue elementValueAtFarmerPosition = getParcelValue(getFarmerPosition());
        setParcelValue(getFarmerPosition(), elementValueAtFarmerPosition == ElementValue.DIRT_AND_FARMER ? ElementValue.DIRT : ElementValue.GRASS);
    }

    void putFarmerOnParcel() {
        ElementValue elementValueAtNewFarmerPosition = getParcelValue(getFarmerPosition());
        setParcelValue(getFarmerPosition(), elementValueAtNewFarmerPosition == ElementValue.DIRT ? ElementValue.DIRT_AND_FARMER : ElementValue.GRASS_AND_FARMER);
    }

}
