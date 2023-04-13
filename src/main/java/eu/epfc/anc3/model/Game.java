package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.List;

class Game {
    private final Farm farm = new Farm();
    private final Farmer farmer = new Farmer();
//    private Carrot carrot = new Carrot();
//    private Cabbage cabbage = new Cabbage();

//    private Grass grass = new Grass();
    private final Day day = new Day();
    private final BooleanProperty farmerMovementEnable = new SimpleBooleanProperty(false);
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

    void autoHarvest(Position position, ElementType elementType){
        scoreProperty.setValue(scoreProperty.getValue() + farm.autoHarvest(position, elementType));
    }
    /*void autoHarvest(Position position, ElementType elementType) {
       List<Element> elements = farm.getValue(position);
       for(Element element : elements) {
           if(element.getType() == ElementType.CARROT) {
               Carrot carrot = (Carrot) element;
               scoreProperty.setValue(scoreProperty.getValue() + carrot.getHarvestScore().get());
           }
              if(element.getType() == ElementType.CABBAGE) {
                Cabbage cabbage = (Cabbage) element;
                scoreProperty.setValue(scoreProperty.getValue() + cabbage.getHarvestScore().get());
              }
       }
        farm.removeElement(position, elementType);
    }*/

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

    /*void plantOrRemove() {
        if (!isMovementEnabled())
            return;
        List<ElementType> newElementList = this.getParcelValue(getFarmerPosition()).stream().map(Element::getType).collect(Collectors.toList());

        List<Element> list = this.getParcelValue(getFarmerPosition());

        for(Element element : list) {
            if(element.getType() == ElementType.CARROT) {
                carrot = (Carrot) element;
            }
            if(element.getType() == ElementType.CABBAGE) {
                cabbage = (Cabbage) element;
            }
            if(element.getType() == ElementType.GRASS) {
               grass = (Grass) element;
            }
        }
        if(gameMode.get() == Mode.PLANT_GRASS && !newElementList.contains(ElementType.GRASS)) {
            if(newElementList.contains(ElementType.CABBAGE)){
                this.removeElement(getFarmerPosition(), ElementType.CABBAGE);
                this.addElement(getFarmerPosition(), new Grass());
                this.addElement(getFarmerPosition(), cabbage);
                cabbage.setHasGrass(true);
            }else{
                this.addElement(getFarmerPosition(), new Grass());
            }
        } else if (gameMode.get() == Mode.PLANT_CARROT && !newElementList.contains(ElementType.CARROT) && !newElementList.contains(ElementType.CABBAGE)){
            if(newElementList.contains(ElementType.GRASS)){
                this.removeElement(getFarmerPosition(), ElementType.GRASS);
                this.addElement(getFarmerPosition(), new Carrot());
                this.addElement(getFarmerPosition(), grass);
            }else{
                this.addElement(getFarmerPosition(), new Carrot());
            }
        } else if (gameMode.get() == Mode.PLANT_CABBAGE && !newElementList.contains(ElementType.CABBAGE) && !newElementList.contains(ElementType.CARROT)) {
            Cabbage newCabbage = new Cabbage();
            this.addElement(getFarmerPosition(),newCabbage);
            if (newElementList.contains(ElementType.GRASS)) {
               newCabbage.setHasGrass(true);
            } else {
                newCabbage.setHasGrass(false);//BooleanProperty hasGrass shouldn't have the input par default value 'false'.
            }
        } else if (gameMode.get() == Mode.HARVEST) {
            if(newElementList.contains(ElementType.CARROT)){
                carrot.setElementHarvestScore();
                this.setScoreProperty(carrot.getHarvestScore().get());
                this.removeElement(getFarmerPosition(), ElementType.CARROT);
            }else if(newElementList.contains(ElementType.CABBAGE)){
                cabbage.setElementHarvestScore();
                this.setScoreProperty(cabbage.getHarvestScore().get());
                this.removeElement(getFarmerPosition(), ElementType.CABBAGE);
            }else if(newElementList.contains(ElementType.GRASS)){
                this.removeElement(getFarmerPosition(), ElementType.GRASS);
            }

        } else if (gameMode.get() == Mode.FERTILIZE) {
            if (newElementList.contains(ElementType.CARROT)) {
                carrot.setIsFertilied(true);
                carrot.fertilize();
            }
        }
    }
    */
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
            /*
            this.removeElement(getFarmerPosition(), ElementType.FARMER);
            setFarmerPosition(position);
            this.addElement(getFarmerPosition(), farmer);*/
        }
    }

    void moveFarmerUp() {
        if(isMovementEnabled()){
            farmer.moveUp(farm);
        }

        /*if (isMovementEnabled() && getFarmerPosition().getY() > 0) {
            this.removeElement(getFarmerPosition(),ElementType.FARMER);
            setFarmerPosition(new Position(getFarmerPosition().getX(),getFarmerPosition().getY()-1));
            this.addElement(getFarmerPosition(), farmer);
        }*/
    }

    void moveFarmerLeft() {
        farmer.moveLeft(farm);

        /*if (isMovementEnabled() && getFarmerPosition().getX() > 0) {
            this.removeElement(getFarmerPosition(), ElementType.FARMER);
            setFarmerPosition(new Position(getFarmerPosition().getX()-1,getFarmerPosition().getY()));
            this.addElement(getFarmerPosition(), farmer);
        }*/
    }

    void moveFarmerRight() {
        farmer.moveRight(farm);

        /*if (isMovementEnabled() && getFarmerPosition().getX() < Farm.FARM_WIDTH - 1) {
            this.removeElement(getFarmerPosition(), ElementType.FARMER);
            setFarmerPosition(new Position(getFarmerPosition().getX()+1,getFarmerPosition().getY()));
            this.addElement(getFarmerPosition(), farmer);
        }*/
    }

    void moveFarmerDown() {
        farmer.moveDown(farm);
        /*if (isMovementEnabled() && getFarmerPosition().getY() < Farm.FARM_HEIGHT - 1) {
            this.removeElement(getFarmerPosition(), ElementType.FARMER);
            setFarmerPosition(new Position(getFarmerPosition().getX(),getFarmerPosition().getY()+1));
            this.addElement(getFarmerPosition(), farmer);
        }*/
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

}
