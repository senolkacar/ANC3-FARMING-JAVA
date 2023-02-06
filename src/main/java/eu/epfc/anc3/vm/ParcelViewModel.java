package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.ParcelValue;
import eu.epfc.anc3.view.GameView;
import eu.epfc.anc3.view.ParcelView;
import javafx.beans.property.ReadOnlyObjectProperty;

public class ParcelViewModel {
    private final int line, col;
    private final GameFacade game;

    public ParcelViewModel(int line,int col,GameFacade game){
        this.line = line;
        this.col = col;
        this.game = game;
    }

    public ReadOnlyObjectProperty<ParcelValue> valueProperty(){
        return game.valueProperty(line,col);
    }
}
