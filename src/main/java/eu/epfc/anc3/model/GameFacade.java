package eu.epfc.anc3.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class GameFacade {

    private final Game game = new Game();

    private final BooleanProperty isStarted = new SimpleBooleanProperty(false);

    public GameFacade(){
        isStarted.bind(gameModeProperty().isEqualTo(Mode.START));

    }

    public static int farmWidth(){
        return Farm.FARM_WIDTH;
    }

    public static int farmHeight(){//
        return Farm.FARM_HEIGHT;
    }

    public void start() {
        game.start();
    }

    public void stop() {
        game.stop();
    }

    public void newGame() {
        game.newGame();
    }

    public ParcelValue teleportFarmer (int line, int col) {
        return game.teleportFarmer(line, col);
    }

    public ReadOnlyObjectProperty<ParcelValue> valueProperty(int line, int col){
        return game.valueProperty(line,col);
    }

    public ReadOnlyObjectProperty<Mode> gameModeProperty() {
        return game.gameModeProperty();
    }

    private Mode mode() {
        return gameModeProperty().get();
    }

    public ReadOnlyBooleanProperty isStartedProperty() {
        return isStarted;
    }




}
