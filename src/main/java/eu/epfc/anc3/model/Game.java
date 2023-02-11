package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Game {
    private Farm farm;
    private final ObjectProperty<Mode> gameMode = new SimpleObjectProperty<>(Mode.FREE);

    void start() {
        farm = new Farm();
        gameMode.set(Mode.START);
    }

    private Mode status() {
        return this.gameMode.get();
    }

    ParcelValue teleportFarmer(int line, int col) {// like game.play
        if (farm.teleportFarmer(line,col,getCurrentParcelValue())){
            ParcelValue parcelValue = ParcelValue.FARMER;//remove farmer from the last stackPane
            return farm.getValue(line, col);
        }
        return ParcelValue.DIRT;
    }

    private ParcelValue getCurrentParcelValue() {
        return  ParcelValue.FARMER;
    }

    ReadOnlyObjectProperty<ParcelValue> valueProperty(int line, int col) {
        return farm.valueProperty(line, col);// farm == null ?
    }

    ReadOnlyObjectProperty<Mode> gameModeProperty() {
        return gameMode;
    }


    public void newGame() {
        gameMode.set(Mode.START);
    }











}
