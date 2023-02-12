package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.Farm;
import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Mode;
import eu.epfc.anc3.model.ParcelValue;


public class FarmViewModel {
    private final GameFacade game;

    public FarmViewModel(GameFacade game) {
        this.game = game;
    }

    public ParcelViewModel getParcelViewModel(int[] position) {
        return new ParcelViewModel(position, game);
    }

    public void plantOrRemoveGrass() {
        if (!game.isMovementEnabled())
            return;

        ParcelValue parcelValueAtFarmerPosition = game.getParcelValue(game.getFarmerPosition());
        if (game.getMode() == Mode.PLANT && parcelValueAtFarmerPosition == ParcelValue.DIRT_AND_FARMER) {
            game.setParcelValue(game.getFarmerPosition(), ParcelValue.GRASS_AND_FARMER);
            game.increaseGrassParcelCount();
        } else if (game.getMode() == Mode.REMOVE && parcelValueAtFarmerPosition == ParcelValue.GRASS_AND_FARMER) {
            game.setParcelValue(game.getFarmerPosition(), ParcelValue.DIRT_AND_FARMER);
            game.decreaseGrassParcelCount();
        }
    }

    public void moveFarmerUp() {
        if (game.isMovementEnabled() && game.getFarmerPosition()[1] > 0) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new int[]{game.getFarmerPosition()[0], game.getFarmerPosition()[1] - 1});
            this.putFarmerOnParcel();
        }
    }

    public void moverFarmerLeft() {
        if (game.isMovementEnabled() && game.getFarmerPosition()[0] > 0) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new int[]{game.getFarmerPosition()[0] - 1, game.getFarmerPosition()[1]});
            this.putFarmerOnParcel();
        }
    }

    public void moveFarmerRight() {
        if (game.isMovementEnabled() && game.getFarmerPosition()[0] < Farm.FARM_WIDTH - 1) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new int[]{game.getFarmerPosition()[0] + 1, game.getFarmerPosition()[1]});
            this.putFarmerOnParcel();
        }
    }

    public void moveFarmerDown() {
        if (game.isMovementEnabled() && game.getFarmerPosition()[1] < Farm.FARM_HEIGHT - 1) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new int[]{game.getFarmerPosition()[0], game.getFarmerPosition()[1] + 1});
            this.putFarmerOnParcel();
        }
    }

    private void removeFarmerFromParcel() {
        ParcelValue parcelValueAtFarmerPosition = game.getParcelValue(game.getFarmerPosition());
        game.setParcelValue(game.getFarmerPosition(), parcelValueAtFarmerPosition == ParcelValue.DIRT_AND_FARMER ? ParcelValue.DIRT : ParcelValue.GRASS);
    }

    private void putFarmerOnParcel() {
        ParcelValue parcelValueAtNewFarmerPosition = game.getParcelValue(game.getFarmerPosition());
        game.setParcelValue(game.getFarmerPosition(), parcelValueAtNewFarmerPosition == ParcelValue.DIRT ? ParcelValue.DIRT_AND_FARMER : ParcelValue.GRASS_AND_FARMER);
    }
}
