package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Mode;
import eu.epfc.anc3.view.FarmView;
import eu.epfc.anc3.view.GameView;

public class MenuViewModel {
    private final GameFacade game;

    public MenuViewModel(GameFacade game) {
        this.game = game;
    }

    public void reset() {
        game.reset();
    }

    public void stop() {
        game.setMovementEnabled(false);
    }



    public void setMode(Mode mode) {
        game.setMode(mode);
    }



}
