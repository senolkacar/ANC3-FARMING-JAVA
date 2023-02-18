package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class Game {
    private Farm farm = new Farm();
    private Farmer farmer = new Farmer();
    private boolean movementEnabled = false;
    private Mode mode = Mode.FREE;
    private final IntegerProperty grassParcelCount = new SimpleIntegerProperty(0);

    public ObjectProperty<Element> getParcelValueProperty(Position position) {
        return farm.valueProperty(position);
    }

    public Element getParcelValue(Position position) {
        return farm.getValue(position);
    }

    public void setParcelValue(Position position, Element value) {
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

        Element elementValueAtFarmerPosition = getParcelValue(getFarmerPosition());
        if (getMode() == Mode.PLANT && elementValueAtFarmerPosition.getType() == Type.DIRT && elementValueAtFarmerPosition.isFarmerOnParcel()) {
            setParcelValue(getFarmerPosition(), new Element(Type.GRASS, true));
            increaseGrassParcelCount();
        } else if (getMode() == Mode.REMOVE && elementValueAtFarmerPosition.getType() == Type.GRASS && elementValueAtFarmerPosition.isFarmerOnParcel()) {
            setParcelValue(getFarmerPosition(), new Element(Type.DIRT, true));
            decreaseGrassParcelCount();
        }
    }

    public void onMouseClicked(Position position) {
        if (isMovementEnabled()) {
            Element newValueOfParcelWithFarmer = getParcelValue(getFarmerPosition()).getType() == Type.DIRT && getParcelValue(getFarmerPosition()).isFarmerOnParcel() ? new Element(Type.DIRT,false) : new Element(Type.GRASS,false);
            setParcelValue(getFarmerPosition(), newValueOfParcelWithFarmer);

            setFarmerPosition(position);

            Element newValueOfParcelWithoutFarmer = getParcelValue(getFarmerPosition()).getType() == Type.DIRT && !getParcelValue(getFarmerPosition()).isFarmerOnParcel() ? new Element(Type.DIRT,true) : new Element(Type.GRASS,true);
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
        Element elementAtFarmerPosition = getParcelValue(getFarmerPosition());
        setParcelValue(getFarmerPosition(), elementAtFarmerPosition.getType() == Type.DIRT && elementAtFarmerPosition.isFarmerOnParcel() ? new Element(Type.DIRT,false) : new Element(Type.GRASS,false));
    }

    void putFarmerOnParcel() {
        Element elementAtNewFarmerPosition = getParcelValue(getFarmerPosition());
        setParcelValue(getFarmerPosition(), elementAtNewFarmerPosition.getType() == Type.DIRT && !elementAtNewFarmerPosition.isFarmerOnParcel() ? new Element(Type.DIRT,true): new Element(Type.GRASS,true));
    }

}
