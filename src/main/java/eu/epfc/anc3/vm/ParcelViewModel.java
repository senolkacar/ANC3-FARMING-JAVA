package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.ElementValue;
import eu.epfc.anc3.model.Position;
import javafx.beans.property.ObjectProperty;

public class ParcelViewModel {
    private final Position position;
    private final GameFacade game;

    public ParcelViewModel(Position position, GameFacade game) {
        this.position = position;
        this.game = game;
    }

    public ObjectProperty<ElementValue> valueProperty() {
        return game.getParcelValueProperty(position);
    }

    public void onMouseClicked() {// ElementValue.DIRT doesn't work
        if (game.isMovementEnabled()) {
            ElementValue newValueOfParcelWithFarmer = game.getParcelValue(game.getFarmerPosition()) == ElementValue.DIRT_AND_FARMER ? ElementValue.DIRT : ElementValue.GRASS;
            game.setParcelValue(game.getFarmerPosition(), newValueOfParcelWithFarmer);

            game.setFarmerPosition(position);

            ElementValue newValueOfParcelWithoutFarmer = game.getParcelValue(game.getFarmerPosition()) == ElementValue.DIRT ? ElementValue.DIRT_AND_FARMER : ElementValue.GRASS_AND_FARMER;
            game.setParcelValue(game.getFarmerPosition(), newValueOfParcelWithoutFarmer);
        }
    }
}
