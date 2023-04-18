package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Mode;
import eu.epfc.anc3.vm.MenuViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MenuView extends HBox {
    private final Button startButton;
    private final Button sleepButton;

    private final Button saveButton;

    private final Button restoreButton;

    private final MenuViewModel menuVM;
    ObjectProperty<Mode> menuModeObjectProperty = new SimpleObjectProperty<>();

    public MenuView(MenuViewModel menuVM) {
        this.setSpacing(10);
        this.setPadding(new Insets(20));

        this.menuVM = menuVM;
        menuModeObjectProperty.bindBidirectional(menuVM.gameModeProperty());

        startButton = new Button();
        sleepButton = new Button();
        saveButton = new Button("Sauver");
        restoreButton = new Button("Restaurer");
        startButton.setFocusTraversable(false);
        sleepButton.setFocusTraversable(false);
        saveButton.setFocusTraversable(false);
        restoreButton.setFocusTraversable(false);

        buttonNameLogic();
        buttonLogic();

        sleepButton.setOnAction(e -> {
            menuVM.sleepButtonAction();
            requestFocus();
        });
        startButton.setOnAction(e -> {
            requestFocus();
            menuVM.OnStartButtonAction();
        });

        saveButton.setOnAction(e -> {
            requestFocus();
            menuVM.OnSaveButtonAction();
        });
        restoreButton.setOnAction(e -> {
            requestFocus();
            menuVM.OnRestoreButtonAction();
        });

        getChildren().addAll(startButton, sleepButton, saveButton, restoreButton);
    }

    private void buttonNameLogic() {
        startButton.textProperty().bind(menuVM.startButtonTextProperty());
        sleepButton.textProperty().bind(menuVM.sleepButtonTextProperty());
    }

    private void buttonLogic() {
        sleepButton.disableProperty().bind(menuVM.farmerMovementEnableProperty().not());
        saveButton.disableProperty().bind(menuVM.farmerMovementEnableProperty().not());
        restoreButton.disableProperty().bind(menuVM.farmerMovementEnableProperty().not());
    }

}
