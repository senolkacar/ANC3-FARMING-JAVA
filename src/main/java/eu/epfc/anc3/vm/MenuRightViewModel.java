package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Mode;
import eu.epfc.anc3.view.MenuRightView;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class MenuRightViewModel {
    private final GameFacade game;

    public MenuRightViewModel(GameFacade game) {
        this.game = game;
    }

    public ObjectProperty<Mode> gameModeProperty() {
        return game.gameModeProperty();
    }

    public void setGameMode(Mode gameMode) {
        game.setGameMode(gameMode);
    }

    public BooleanProperty farmerMovementEnableProperty() {
        return game.farmerMovementEnableProperty();
    }

    public void harvestAction(ObjectProperty<Mode> menuModeObjectProperty, ToggleButton harvestButton, MenuRightView menuRightView) {
        menuRightView.requestFocus();
        if (menuModeObjectProperty.get() == Mode.HARVEST) {
            setGameMode(Mode.FREE);
        } else {
            setGameMode(Mode.HARVEST);
            harvestButton.isSelected();

        }
    }

    public void fertilizeAction(ObjectProperty<Mode> menuModeObjectProperty, ToggleButton fertilizeButton, MenuRightView menuRightView) {
        menuRightView.requestFocus();
        if (menuModeObjectProperty.get() == Mode.FERTILIZE) {
            setGameMode(Mode.FREE);
        } else {
            setGameMode(Mode.FERTILIZE);
            fertilizeButton.isSelected();
        }
    }

    public void plantCabbageAction(ObjectProperty<Mode> menuModeObjectProperty, ToggleButton plantCabbageButton, MenuRightView menuRightView) {
        menuRightView.requestFocus();
        if (menuModeObjectProperty.get() == Mode.PLANT_CABBAGE) {
            setGameMode(Mode.FREE);
        } else {
            setGameMode(Mode.PLANT_CABBAGE);
            plantCabbageButton.isSelected();
        }
    }

    public void plantCarrotAction(ObjectProperty<Mode> menuModeObjectProperty, ToggleButton plantCarrotButton, MenuRightView menuRightView) {
        menuRightView.requestFocus();
        if (menuModeObjectProperty.get() == Mode.PLANT_CARROT) {
            setGameMode(Mode.FREE);
        } else {
            setGameMode(Mode.PLANT_CARROT);
            plantCarrotButton.isSelected();
        }
    }

    public void plantGrassAction(ObjectProperty<Mode> menuModeObjectProperty, ToggleButton plantGrassButton, MenuRightView menuRightView) {
        menuRightView.requestFocus();
        if (menuModeObjectProperty.get() == Mode.PLANT_GRASS) {
            setGameMode(Mode.FREE);
        } else {
            setGameMode(Mode.PLANT_GRASS);
            plantGrassButton.isSelected();

        }

    }

    public void setSelectedButton(Mode newVal, ToggleGroup actionToggleGroup, MenuRightView menuRightView) {
        menuRightView.requestFocus();
        if (newVal == Mode.PLANT_CABBAGE) {
            actionToggleGroup.selectToggle(menuRightView.plantCabbageButton);
        }else if (newVal == Mode.PLANT_CARROT)
            actionToggleGroup.selectToggle(menuRightView.plantCarrotButton);
        else if (newVal == Mode.PLANT_GRASS)
            actionToggleGroup.selectToggle(menuRightView.plantGrassButton);
        else if (newVal == Mode.FERTILIZE)
            actionToggleGroup.selectToggle(menuRightView.fertilizeButton);
        else if (newVal == Mode.HARVEST)
            actionToggleGroup.selectToggle(menuRightView.harvestButton);
    }
}
