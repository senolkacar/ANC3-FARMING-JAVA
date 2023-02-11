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
        game.gameModeProperty().addListener((obs,old,newval) -> refreshMode(newval));
    }

    private void refreshMode(Mode mode) {

    }

    public void start() {
        game.start();
    }

    public void stop(){
        game.stop();
    }

    public void newGame() {
        game.newGame();
    }
    public ReadOnlyBooleanProperty isGameStartedProperty() {
        return game.isStartedProperty();
    }







}
