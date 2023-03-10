package eu.epfc.anc3.model;

import javafx.beans.property.*;
import javafx.geometry.Pos;

import java.util.List;
import java.util.Set;

class Game {
    private final Farm farm = new Farm();
    private final Dirt dirt = new Dirt();
    private final Grass grass = new Grass();
    private final Farmer farmer = new Farmer();
    private  Carrot carrot = new Carrot();
    private final Cabbage cabbage = new Cabbage();
    private final Day day = new Day();
    //private boolean movementEnabled = false;
    private BooleanProperty farmerMovementEnable = new SimpleBooleanProperty(false);

    private final IntegerProperty grassParcelCount = new SimpleIntegerProperty(0);
    private final IntegerProperty scoreProperty = new SimpleIntegerProperty(0);
    private final ObjectProperty<Mode> gameMode = new SimpleObjectProperty<>(Mode.FREE);

    IntegerProperty getDayProperty(){
        return day.dayPropertyProperty();
    }


    void start(){
        farmer.setPosition(new Position(0, 0));
        farm.reset();
        gameMode.set(Mode.FREE);
        //mode = Mode.FREE;
        grassParcelCount.setValue(0);
        farmerMovementEnable.set(false);
        //movementEnabled = false;
    }

    void reset() {
        this.start();
        day.resetDayProperty();
        farmerMovementEnable.set(true);
        //movementEnabled = true;
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


    void plantOrRemove() {
        if (!isMovementEnabled())
            return;


        if(gameMode.get() == Mode.PLANT_GRASS&& !this.containsElement(getFarmerPosition(), grass)) {//with legumes?
                this.removeElement(getFarmerPosition(), dirt);
                this.addElement(getFarmerPosition(), grass);
                increaseGrassParcelCount();
            } else if (gameMode.get() == Mode.PLANT_CARROT && !this.containsElement(getFarmerPosition(),carrot)){
                this.addElement(getFarmerPosition(), new Carrot());
               // this.setCorrotimageProperty(getFarmerPosition());//

            } else if (gameMode.get() == Mode.PLANT_CABBAGE && !this.containsElement(getFarmerPosition(),cabbage)) {
                this.addElement(getFarmerPosition(),new Cabbage());
            } else if (gameMode.get() == Mode.HARVEST) {
                if (this.containsElement(getFarmerPosition(),carrot))
                    this.removeElement(getFarmerPosition(),carrot);
                else if (this.containsElement(getFarmerPosition(),cabbage))
                    this.removeElement(getFarmerPosition(),cabbage);
            }

//        System.out.println("position : " + getFarmerPosition());
//        System.out.println("list : " + getParcelValue(getFarmerPosition()));
//        List<Element> list = getParcelValue(getFarmerPosition());
//        for (int i = 0; i < list.size() ; i++) {
//            System.out.println(list.get(i));
//            if (list.get(i) instanceof Carrot){
//                System.out.println(((Carrot) list.get(i)).getCarrotState());
//            }
//        }
//        System.out.println(this.getCarrotImageProperty(getFarmerPosition()));
//        System.out.println(this.getCarrotImage(getFarmerPosition()));

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


    public BooleanProperty farmerMovementEnableProperty() {
        return farmerMovementEnable;
    }

    public ReadOnlyIntegerProperty getScoreProperty() {
        return scoreProperty;
    }

    public void setScoreProperty(int score) {
        scoreProperty.set(scoreProperty.get()+score);
    }


    public boolean containsCarrot(Position position) {
        return containsElement(position,carrot);
    }
}
