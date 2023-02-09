package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Game {
    private Farm farm;
    private final ObjectProperty<GameStatus> gameStatus = new SimpleObjectProperty<>(GameStatus.FREE);//change GameStatus to Mode?

    void start() {
        farm = new Farm();
        gameStatus.set(GameStatus.START);
    }

    private GameStatus status() {
        return this.gameStatus.get();
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

    ReadOnlyObjectProperty<GameStatus> gameStatusProperty() {
        return gameStatus;
    }


    public void newGame() {
        gameStatus.set(GameStatus.START);
    }











}
