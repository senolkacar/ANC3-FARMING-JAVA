package eu.epfc.anc3.model;

import javafx.beans.property.ReadOnlyObjectProperty;

public class GameFacade {

    private final Game game = new Game();

    public GameFacade(){

    }

    public static int farmWidth(){
        return Farm.FARM_WIDTH;
    }

    public static int farmHeight(){
        return Farm.FARM_HEIGHT;
    }

    public ReadOnlyObjectProperty<ParcelValue> valueProperty(int line, int col){
        return game.valueProperty(line,col);
    }
}
