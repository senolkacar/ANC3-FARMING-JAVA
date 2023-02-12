package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Mode;
import eu.epfc.anc3.vm.MenuViewModel;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MenuView extends HBox {
    private final Button startButton;
    private final Button plantButton;
    private final Button removeButton;

    private final MenuViewModel menuVM;

    public MenuView(MenuViewModel menuVM) {
        this.menuVM = menuVM;

        startButton = new Button("Démarrer");
        plantButton = new Button("Planter du gazon");
        removeButton = new Button("Enlever du gazon");
        plantButton.setDisable(true);
        removeButton.setDisable(true);

        startButton.setOnAction(e -> this.onStartButtonAction());
        plantButton.setOnAction(e -> menuVM.setMode(Mode.PLANT));
        removeButton.setOnAction(e -> menuVM.setMode(Mode.REMOVE));

        getChildren().addAll(startButton, plantButton, removeButton);
    }

    private void onStartButtonAction() {
        if (startButton.getText().equals("Démarrer")) {
            menuVM.reset();
            plantButton.setDisable(false);
            removeButton.setDisable(false);
            startButton.setText("Arrêter");
        } else {
            menuVM.stop();
            plantButton.setDisable(true);
            removeButton.setDisable(true);
            startButton.setText("Démarrer");
        }
    }
}
