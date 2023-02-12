package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.ParcelValue;
import javafx.beans.property.ObjectProperty;

public class ParcelViewModel {
    private final int[] position;
    private final GameFacade game;

    public ParcelViewModel(int[] position, GameFacade game) {
        this.position = position;
        this.game = game;
    }

    public ObjectProperty<ParcelValue> valueProperty() {
        return game.getParcelValueProperty(position);
    }

    public void onMouseClicked() {
        if (game.isMovementEnabled()) {
            ParcelValue newValueOfParcelWithFarmer = game.getParcelValue(game.getFarmerPosition()) == ParcelValue.DIRT_AND_FARMER ? ParcelValue.DIRT : ParcelValue.GRASS;
            game.setParcelValue(game.getFarmerPosition(), newValueOfParcelWithFarmer);

            game.setFarmerPosition(position);

            ParcelValue newValueOfParcelWithoutFarmer = game.getParcelValue(game.getFarmerPosition()) == ParcelValue.DIRT ? ParcelValue.DIRT_AND_FARMER : ParcelValue.GRASS_AND_FARMER;
            game.setParcelValue(game.getFarmerPosition(), newValueOfParcelWithoutFarmer);
        }
    }
}
