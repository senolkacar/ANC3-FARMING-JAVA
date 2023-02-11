package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Mode;
import eu.epfc.anc3.view.FarmView;
import javafx.beans.property.ReadOnlyObjectProperty;

public class FarmViewModel {
    private final GameFacade game;

    public FarmViewModel(GameFacade game) {
        this.game = game;
    }

    public ParcelViewModel getParcelViewModel(int line, int col){
        return new ParcelViewModel(line,col,game);
    }

    public FarmView getFarmView() {
        FarmView farmView =  new FarmView(this);
        return farmView;
    }

    public ReadOnlyObjectProperty<Mode> gameModeProperty() {
        return game.gameModeProperty();
    }

}
