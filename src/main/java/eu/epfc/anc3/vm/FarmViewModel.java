package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.*;

public class FarmViewModel {
    private final GameFacade game;

    public FarmViewModel(GameFacade game) {
        this.game = game;
    }

    public ParcelViewModel getParcelViewModel(Position position) {
        return new ParcelViewModel(position, game);
    }
}
