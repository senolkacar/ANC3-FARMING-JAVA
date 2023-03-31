package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Mode;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;

public class MenuRightViewModel {

    private final GameFacade game;

    public MenuRightViewModel(GameFacade game) {
        this.game = game;
    }

    public ObjectProperty<Mode> gameModeProperty() {
        return game.gameModeProperty();
    }

    public void setGameMode(Mode gameMode) {
        game.setGameMode(gameMode);
    }

    public BooleanProperty farmerMovementEnableProperty() {
        return game.farmerMovementEnableProperty();

    }
}
