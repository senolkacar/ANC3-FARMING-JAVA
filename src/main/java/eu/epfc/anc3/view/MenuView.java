package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.MenuViewModel;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MenuView extends HBox {
    private final Button startButton = new Button("Démarrer");
    private final Button plantButton = new Button("Planter du gazon");
    private final Button removeButton = new Button("Enlever du gazon");

    private final MenuViewModel menuViewModel;

    public MenuView(MenuViewModel menuViewModel) {
        this.menuViewModel = menuViewModel;
        configMenu();
    }

    private void configMenu() {
        getChildren().addAll(startButton,plantButton,removeButton);
    }










}
