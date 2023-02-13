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

    public void plantOrRemoveGrass() { // dans game model
        if (!game.isMovementEnabled())
            return;

        ElementValue elementValueAtFarmerPosition = game.getParcelValue(game.getFarmerPosition());
        if (game.getMode() == Mode.PLANT && elementValueAtFarmerPosition == ElementValue.DIRT_AND_FARMER) {
            game.setParcelValue(game.getFarmerPosition(), ElementValue.GRASS_AND_FARMER);
            game.increaseGrassParcelCount();
        } else if (game.getMode() == Mode.REMOVE && elementValueAtFarmerPosition == ElementValue.GRASS_AND_FARMER) {
            game.setParcelValue(game.getFarmerPosition(), ElementValue.DIRT_AND_FARMER);
            game.decreaseGrassParcelCount();
        }
    }

    public void moveFarmerUp() {
        if (game.isMovementEnabled() && game.getFarmerPosition().getY() > 0) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new Position(game.getFarmerPosition().getX(),game.getFarmerPosition().getY()-1));
            System.out.println(game.getFarmerPosition().getX()+" "+game.getFarmerPosition().getY());
            this.putFarmerOnParcel();
        }
    }

    public void moverFarmerLeft() {
        if (game.isMovementEnabled() && game.getFarmerPosition().getX() > 0) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new Position(game.getFarmerPosition().getX()-1,game.getFarmerPosition().getY()));
            System.out.println(game.getFarmerPosition().getX()+" "+game.getFarmerPosition().getY());
            this.putFarmerOnParcel();
        }
    }

    public void moveFarmerRight() {
        if (game.isMovementEnabled() && game.getFarmerPosition().getX() < Farm.FARM_WIDTH - 1) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new Position(game.getFarmerPosition().getX()+1,game.getFarmerPosition().getY()));
           System.out.println(game.getFarmerPosition().getX()+" "+game.getFarmerPosition().getY());
            this.putFarmerOnParcel();
        }
    }

    public void moveFarmerDown() {
        if (game.isMovementEnabled() && game.getFarmerPosition().getY() < Farm.FARM_HEIGHT - 1) {
            this.removeFarmerFromParcel();
            game.setFarmerPosition(new Position(game.getFarmerPosition().getX(),game.getFarmerPosition().getY()+1));
            System.out.println(game.getFarmerPosition().getX()+" "+game.getFarmerPosition().getY());
            this.putFarmerOnParcel();
        }
    }

    private void removeFarmerFromParcel() {
        ElementValue elementValueAtFarmerPosition = game.getParcelValue(game.getFarmerPosition());
        game.setParcelValue(game.getFarmerPosition(), elementValueAtFarmerPosition == ElementValue.DIRT_AND_FARMER ? ElementValue.DIRT : ElementValue.GRASS);
    }

    private void putFarmerOnParcel() {
        ElementValue elementValueAtNewFarmerPosition = game.getParcelValue(game.getFarmerPosition());
        game.setParcelValue(game.getFarmerPosition(), elementValueAtNewFarmerPosition == ElementValue.DIRT ? ElementValue.DIRT_AND_FARMER : ElementValue.GRASS_AND_FARMER);
    }
}
