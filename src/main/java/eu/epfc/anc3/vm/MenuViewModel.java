package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameCaretaker;
import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Mode;
import eu.epfc.anc3.view.FarmView;
import eu.epfc.anc3.view.GameView;
import javafx.beans.property.*;

import java.net.HttpCookie;

public class MenuViewModel {
    private final GameFacade game;
    private final GameCaretaker caretaker = new GameCaretaker();

    SimpleStringProperty startButtonText = new SimpleStringProperty("Démarrer");

    public SimpleStringProperty startButtonTextProperty() {
        return startButtonText;
    }

    public ReadOnlyStringProperty sleepButtonTextProperty() {
        return new SimpleStringProperty("Dormir");
    }

    public ReadOnlyBooleanProperty farmerMovementEnableProperty() {
        return game.farmerMovementEnableProperty();
    }

    public MenuViewModel(GameFacade game) {
        this.game = game;
    }

    public void reset() {
        game.reset();
    }

    public void stop() {
        game.setMovementEnabled(false);
    }

    public ObjectProperty<Mode> gameModeProperty() {
        return game.gameModeProperty();
    }

    public void setGameMode(Mode gameMode) {
        game.setGameMode(gameMode);
    }

    public void sleepButtonAction() {
         game.increaseDayProperty();
    }

    public void OnStartButtonAction() {
        if(game.farmerMovementEnableProperty().get()) {
            game.setMovementEnabled(false);
            startButtonTextProperty().set("Démarrer");
        } else {
            game.reset();
            startButtonTextProperty().set("Arrêter");
        }
    }

    public void OnSaveButtonAction() {
        caretaker.saveState(game);
    }

    public void OnRestoreButtonAction() {
        int mementoCount = caretaker.getMementoCount();
        if (mementoCount > 0) {
            int index = mementoCount - 1; // Restore the most recent state
            caretaker.restoreState(game, index);
        }
    }
}
