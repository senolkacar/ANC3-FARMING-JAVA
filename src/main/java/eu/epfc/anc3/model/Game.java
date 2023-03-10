package eu.epfc.anc3.model;

import javafx.beans.property.*;
import javafx.geometry.Pos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Game {
    private final Farm farm = new Farm();
    private final Dirt dirt = new Dirt();
    private final Grass grass = new Grass();
    private final Farmer farmer = new Farmer();
    private Carrot carrot = new Carrot();
    private Cabbage cabbage = new Cabbage();
    private final Day day = new Day();

    private BooleanProperty farmerMovementEnable = new SimpleBooleanProperty(false);
    private final IntegerProperty scoreProperty = new SimpleIntegerProperty(0);
    private final ObjectProperty<Mode> gameMode = new SimpleObjectProperty<>(Mode.FREE);

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

    ListProperty<Element> getParcelValueProperty(Position position) {
        return farm.valueProperty(position);
    }

    List<Element> getParcelValue(Position position) {
        return farm.getValue(position);
    }

//    String getCarrotImage(Position position) {
//        return farm.getCarrotImage(position);
//    }
//
//    StringProperty getCarrotImageProperty(Position position) {
//        return farm.getCarrotImageProperty(position);
//    }
//
//    void setCorrotimageProperty(Position position) {
//        farm.setCarrotImage(position);
//    }
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
        return farmerMovementEnable.get();
    }

    void setMovementEnabled(boolean movementEnabled) {
        this.farmerMovementEnable.set(movementEnabled);
    }

    void plantOrRemove() {
        if (!isMovementEnabled())
            return;

        List<Element> list = null;
        if (this.containsElement(getFarmerPosition(),carrot))
            list = this.getParcelValue(getFarmerPosition()).stream().filter(e->e.elementType==ElementType.CARROT).limit(1).collect(Collectors.toList());
        else if (this.containsElement(getFarmerPosition(),cabbage))
            list = this.getParcelValue(getFarmerPosition()).stream().filter(e->e.elementType==ElementType.CABBAGE).limit(1).collect(Collectors.toList());

        if(gameMode.get() == Mode.PLANT_GRASS && !this.containsElement(getFarmerPosition(), grass)) {
            this.removeElement(getFarmerPosition(), dirt);
            this.addElement(getFarmerPosition(), grass);
            if (this.containsElement(getFarmerPosition(),cabbage)){
                if (list.size()>0){
                    list.get(0).setHasGrass(true);
                }
            }
            //increaseGrassParcelCount();
        } else if (gameMode.get() == Mode.PLANT_CARROT && !this.containsElement(getFarmerPosition(),carrot) && !this.containsElement(getFarmerPosition(),cabbage)){
            this.addElement(getFarmerPosition(), new Carrot());
            // this.setCorrotimageProperty(getFarmerPosition());//

        } else if (gameMode.get() == Mode.PLANT_CABBAGE && !this.containsElement(getFarmerPosition(),cabbage) && !this.containsElement(getFarmerPosition(),carrot)) {
            this.addElement(getFarmerPosition(),new Cabbage());
            if (this.containsElement(getFarmerPosition(),grass)) {
                if (list != null && list.size()>0){
                    list.get(0).setHasGrass(true); //doesn't work ?
                }
            }
        } else if (gameMode.get() == Mode.HARVEST) {
            if (this.containsElement(getFarmerPosition(),carrot)){
                if (list != null && list.size()>0){
                    list.get(0).setElementHarvestScore();
                    this.setScoreProperty(list.get(0).getHarvestScore().get());
                }
                this.removeElement(getFarmerPosition(),carrot);
            } else if (this.containsElement(getFarmerPosition(),cabbage)){
                if (list != null && list.size()>0){
                    list.get(0).setElementHarvestScore();
                    this.setScoreProperty(list.get(0).getHarvestScore().get());
                }
                this.removeElement(getFarmerPosition(),cabbage);
            }

//            if (this.containsElement(getFarmerPosition(),carrot) ||this.containsElement(getFarmerPosition(),cabbage) ) {
//                if (list != null && list.size()>0){
//                    list.get(0).setElementHarvestScore();
//                    this.setScoreProperty(list.get(0).getHarvestScore().get());
//                }
//                if (this.containsElement(getFarmerPosition(),carrot)) {
//                    this.removeElement(getFarmerPosition(),carrot);
//                }else if (this.containsElement(getFarmerPosition(),cabbage))
//                    this.removeElement(getFarmerPosition(),cabbage);
//            }
        } else if (gameMode.get() == Mode.FERTILIZE) {
            if (this.containsElement(getFarmerPosition(),carrot)) {
                if (list.size()>0){
                    list.get(0).setIsFertilied(true);
                    list.get(0).fertilize();
                }
            }

        }
//        List<Element> list = getParcelValue(getFarmerPosition());
//        for (int i = 0; i < list.size() ; i++) {
//            System.out.println(list.get(i));
//            if (list.get(i) instanceof Carrot){
//                System.out.println(((Carrot) list.get(i)).getCarrotState());
//            }
//        }
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


    BooleanProperty farmerMovementEnableProperty() {
        return farmerMovementEnable;
    }

    ReadOnlyIntegerProperty getScoreProperty() {
        return scoreProperty;
    }

    void setScoreProperty(int score) {
        scoreProperty.set(scoreProperty.get()+score);
    }


    boolean containsCarrot(Position position) {
        return containsElement(position,carrot);
    }
}
