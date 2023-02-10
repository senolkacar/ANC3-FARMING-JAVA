package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class GameFacade {
    private final Farmer farmer = new Farmer();
    private final Game game = new Game();

    private final BooleanProperty isStarted = new SimpleBooleanProperty(false);
    private final BooleanProperty isStopped = new SimpleBooleanProperty(false);

    public GameFacade() {
        isStarted.bind(game.gameStatusProperty().isEqualTo(GameStatus.STARTED));
        isStopped.bind(game.gameStatusProperty().isEqualTo(GameStatus.STOPPED));
    }

    public static int farmWidth() {
        return Farm.FARM_WIDTH;
    }

    public static int farmHeight() {
        return Farm.FARM_HEIGHT;
    }

    public IntegerProperty gazonScoreProperty() {
        return farmer.gazonScoreProperty();
    }

    public void start() {
        game.start();
    }
    public void stop() {
        game.stop();
    }

    private GameStatus gameStatus() {
        return game.gameStatusProperty().get();
    }
    private ActionStatus actionStatus() {
        return game.actionStatusProperty().get();
    }

    public int getGazonScore() {
        return farmer.gazonScoreProperty().get();
    }

    public ReadOnlyBooleanProperty isStartedProperty() {
        return isStarted;
    }
    public ReadOnlyBooleanProperty isStoppedProperty() {
        return isStopped;
    }


}
