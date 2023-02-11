package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Game {
    private Farm farm;
    private final ObjectProperty<GameStatus> gameStatus = new SimpleObjectProperty<>(GameStatus.STARTED);
    private final ObjectProperty<ActionStatus> actionStatus = new SimpleObjectProperty<>(ActionStatus.FREE);

    void start() {
        farm = new Farm();
        gameStatus.set(GameStatus.STARTED);
        actionStatus.set(ActionStatus.FREE);
    }

    void stop(){
        gameStatus.set(GameStatus.STOPPED);
        actionStatus.set(ActionStatus.DISABLED);
    }

    ReadOnlyObjectProperty<GameStatus> gameStatusProperty() {
        return gameStatus;
    }

    ReadOnlyObjectProperty<ActionStatus> actionStatusProperty() {
        return actionStatus;
    }

    ReadOnlyObjectProperty<Type> valueProperty(int line, int col) {
        return farm.valueProperty(line, col);
    }



}
