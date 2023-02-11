package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.GameViewModel;
import eu.epfc.anc3.vm.MenuViewModel;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import static eu.epfc.anc3.view.GameView.MOVEMENTENABLED;

public class MenuView extends HBox {
    private final Button startButton = new Button("Démarrer");
    private final Button plantButton = new Button("Planter du gazon");
    private final Button removeButton = new Button("Enlever du gazon");

    private final MenuViewModel menuViewModel;

    public MenuView(MenuViewModel menuViewModel) {
        this.menuViewModel = menuViewModel;
        configMenu();
        manageStartButton();
    }

    private void configMenu() {
        getChildren().addAll(startButton,plantButton,removeButton);

    }

    private void manageStartButton() {
        startButton.setOnAction(e->{
            if (startButton.getText().equals("Démarrer") ){
                menuViewModel.start();
                MOVEMENTENABLED = true;
                startButton.setText("Areter");
            }
            else {
                MOVEMENTENABLED = false;
                menuViewModel.stop();
                startButton.setText("Démarrer");
            }
        });

    }










}
