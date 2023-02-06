package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;

public class FarmViewModel {
    private final GameFacade game;

    public FarmViewModel(GameFacade game) {
        this.game = game;
    }

    public ParcelViewModel getParcelViewModel(int line, int col){
        return new ParcelViewModel(line,col,game);
    }

}
