package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.List;
import java.util.Set;

class Game {
    private final Farm farm = new Farm();
    private final Dirt dirt = new Dirt();
    private final Grass grass = new Grass();
    private final Farmer farmer = new Farmer();
    private final Cabbage cabbage = new Cabbage();
    private final Carrot carrot = new Carrot();
    private final Day day = new Day();
    private boolean movementEnabled = false;

    private final IntegerProperty grassParcelCount = new SimpleIntegerProperty(0);
    private final ObjectProperty<Mode> gameMode = new SimpleObjectProperty<>(Mode.FREE);
    private final IntegerProperty scoreProperty = new SimpleIntegerProperty(0);

    IntegerProperty getDayProperty(){
        return day.dayPropertyProperty();
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

    Carrot getCarrot(Position position) {
        return farm.getCarrot(position);
    }

    Cabbage getCabbage(Position position) {
        return farm.getCabbage(position);
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

    ReadOnlyIntegerProperty getScoreProperty() {
        return scoreProperty;
    }

    void setScoreProperty(int score) {
        scoreProperty.setValue(this.scoreProperty.getValue() + score);
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

    void plantOrRemove() {
        if (!isMovementEnabled())
            return;
        if(gameMode.get() == Mode.PLANT_GRASS&& !this.containsElement(getFarmerPosition(), grass)) {
                this.removeElement(getFarmerPosition(), dirt);
                this.addElement(getFarmerPosition(), grass);
                increaseGrassParcelCount();
            }
        else if(gameMode.get() == Mode.PLANT_CARROT && !this.containsElement(getFarmerPosition(), carrot) && !this.containsElement(getFarmerPosition(), cabbage)) {
                this.addElement(getFarmerPosition(), new Carrot());
            }
        else if (gameMode.get() == Mode.PLANT_CABBAGE && !this.containsElement(getFarmerPosition(), cabbage) && !this.containsElement(getFarmerPosition(), carrot)) {
                this.addElement(getFarmerPosition(), new Cabbage());
            }
        else if (gameMode.get() == Mode.HARVEST && this.containsElement(getFarmerPosition(), carrot)) {
                this.setScoreProperty((int)this.getCarrot(getFarmerPosition()).harvest());
                this.removeElement(getFarmerPosition(), new Carrot());
            }
        else if (gameMode.get() == Mode.HARVEST && this.containsElement(getFarmerPosition(), cabbage)) {
                this.setScoreProperty((int)this.getCabbage(getFarmerPosition()).harvest());
                this.removeElement(getFarmerPosition(), new Cabbage());
        }
        else if (gameMode.get() == Mode.HARVEST && this.containsElement(getFarmerPosition(), grass)) {
                this.removeElement(getFarmerPosition(), grass);
                this.addElement(getFarmerPosition(), dirt);
                decreaseGrassParcelCount();
        }else if (gameMode.get() == Mode.FERTILIZE && this.containsElement(getFarmerPosition(), carrot)) {
            if(this.getCarrot(getFarmerPosition()).getState()<3){
                this.getCarrot(getFarmerPosition()).setState(3);
            }

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
            for(Element element : getParcelValue(getFarmerPosition())) {
                System.out.println(element.getType()+" "+element.getState());
            }
        }
    }

    void moveFarmerLeft() {
        if (isMovementEnabled() && getFarmerPosition().getX() > 0) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX()-1,getFarmerPosition().getY()));
            this.addElement(getFarmerPosition(), farmer);
            for(Element element : getParcelValue(getFarmerPosition())) {
                System.out.println(element.getType()+" "+element.getState());
            }
        }
    }

    void moveFarmerRight() {
        if (isMovementEnabled() && getFarmerPosition().getX() < Farm.FARM_WIDTH - 1) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX()+1,getFarmerPosition().getY()));
            this.addElement(getFarmerPosition(), farmer);
            for(Element element : getParcelValue(getFarmerPosition())) {
                System.out.println(element.getType()+" "+element.getState());
            }
        }
    }

    void moveFarmerDown() {
        if (isMovementEnabled() && getFarmerPosition().getY() < Farm.FARM_HEIGHT - 1) {
            this.removeElement(getFarmerPosition(), farmer);
            setFarmerPosition(new Position(getFarmerPosition().getX(),getFarmerPosition().getY()+1));
            this.addElement(getFarmerPosition(), farmer);
            for(Element element : getParcelValue(getFarmerPosition())) {
                System.out.println(element.getType()+" "+element.getState());
            }
        }
    }


}
