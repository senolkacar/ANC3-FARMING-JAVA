package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Mode;
import javafx.beans.property.ReadOnlyBooleanProperty;

public class MenuViewModel {
    private final GameFacade game;
    public MenuViewModel(GameFacade game) {
        this.game = game;
    }

    private void configLogicStatus() {
        game.gameStatusProperty().addListener((obs,old,newval) -> refreshStatus(newval));
    }

    private void refreshStatus(Mode status) {

    }

    public void start() {
        game.start();
    }

    public void newGame() {
        game.newGame();
    }
    public ReadOnlyBooleanProperty isGameStartedProperty() {
        return game.isStartedProperty();
    }







}
