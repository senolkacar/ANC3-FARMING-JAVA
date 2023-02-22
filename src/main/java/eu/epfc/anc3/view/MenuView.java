    package eu.epfc.anc3.view;

    import eu.epfc.anc3.model.Mode;
    import eu.epfc.anc3.vm.MenuViewModel;
    import javafx.beans.property.ObjectProperty;
    import javafx.beans.property.SimpleObjectProperty;
    import javafx.scene.control.Button;
    import javafx.scene.control.ToggleButton;
    import javafx.scene.control.ToggleGroup;
    import javafx.scene.layout.HBox;

    public class MenuView extends HBox {
        private final Button startButton;

        private final ToggleGroup actionToggleGroup;
        private final ToggleButton plantButton;
        private final ToggleButton removeButton;
        private final MenuViewModel menuVM;
        ObjectProperty<Mode> menuModeObjectProperty = new SimpleObjectProperty<>();

        public MenuView(MenuViewModel menuVM) {
            this.menuVM = menuVM;
            menuModeObjectProperty.bindBidirectional(menuVM.gameModeProperty());

            actionToggleGroup = new ToggleGroup();
            startButton = new Button("Démarrer");
            plantButton = new ToggleButton("Planter du gazon");
            removeButton = new ToggleButton("Enlever du gazon");
            plantButton.setToggleGroup(actionToggleGroup);
            removeButton.setToggleGroup(actionToggleGroup);
            plantButton.setDisable(true);
            removeButton.setDisable(true);

            startButton.setOnAction(e -> this.onStartButtonAction());
            plantButton.setOnAction(e -> {
                menuModeObjectProperty.set(Mode.PLANT);
                this.onModeButtonAction(menuModeObjectProperty);});
            removeButton.setOnAction(e -> {
                menuModeObjectProperty.set(Mode.REMOVE);
                this.onModeButtonAction(menuModeObjectProperty);});

            setFocusTraversable(false);
            startButton.setFocusTraversable(false);
            plantButton.setFocusTraversable(false);
            removeButton.setFocusTraversable(false);
            getChildren().addAll(startButton, plantButton, removeButton);
        }

        private void onStartButtonAction() {
            if (startButton.getText().equals("Démarrer")) {
                menuVM.reset();
                plantButton.setDisable(false);
                removeButton.setDisable(false);
                removeButton.setSelected(false);
                plantButton.setSelected(false);
                startButton.setText("Arrêter");
            } else {
                menuVM.stop();
                plantButton.setDisable(true);
                removeButton.setDisable(true);
                startButton.setText("Démarrer");
            }
        }
        private void onModeButtonAction(ObjectProperty<Mode> menuModeObjectProperty) {
            if (menuModeObjectProperty.get() == Mode.PLANT) {
                removeButton.setSelected(false);
            } else {
                plantButton.setSelected(false);
            }
            menuModeObjectProperty.set(actionToggleGroup.getSelectedToggle() == null ? Mode.FREE : menuModeObjectProperty.get());
        }
    }
