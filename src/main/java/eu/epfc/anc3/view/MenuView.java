    package eu.epfc.anc3.view;

    import eu.epfc.anc3.model.Mode;
    import eu.epfc.anc3.vm.MenuViewModel;
    import javafx.beans.property.ObjectProperty;
    import javafx.beans.property.SimpleObjectProperty;
    import javafx.scene.control.Button;
    import javafx.scene.control.ToggleButton;
    import javafx.scene.control.ToggleGroup;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.HBox;

    public class MenuView extends HBox {
        private final Button startButton;
        private final Button sleepButton;

        private final ToggleGroup actionToggleGroup;
        private final ToggleButton plantGrassButton;
        private final ToggleButton plantCarrotButton;

        private final ToggleButton plantCabbageButton;

        private final ToggleButton fertilizeButton;
        private final ToggleButton harvestButton;

        private final Image grass = new Image("grass.png");
        ImageView grassImageView = new ImageView(grass);
        private final Image carrot = new Image("carrot4.png");
        ImageView carrotImageView = new ImageView(carrot);
        private final Image cabbage = new Image("cabbage4.png");
        ImageView cabbageImageView = new ImageView(cabbage);
        private final Image fertilizer = new Image("watering_can.png");
        ImageView fertilizerImageView = new ImageView(fertilizer);
        private final Image harvest = new Image("shovel.png");
        ImageView harvestImageView = new ImageView(harvest);

        private final MenuViewModel menuVM;
        ObjectProperty<Mode> menuModeObjectProperty = new SimpleObjectProperty<>();

        public MenuView(MenuViewModel menuVM) {
            this.menuVM = menuVM;
            menuModeObjectProperty.bindBidirectional(menuVM.gameModeProperty());

            actionToggleGroup = new ToggleGroup();
            startButton = new Button("Démarrer");
            sleepButton = new Button("Dormir");
            plantGrassButton = new ToggleButton("Planter du gazon");
            plantCarrotButton = new ToggleButton("Planter des carottes");
            plantCabbageButton = new ToggleButton("Planter du chou");
            fertilizeButton = new ToggleButton("Fertiliser");
            harvestButton = new ToggleButton("Récolter");
            plantGrassButton.setGraphic(grassImageView);
            plantCarrotButton.setGraphic(carrotImageView);
            plantCabbageButton.setGraphic(cabbageImageView);
            fertilizeButton.setGraphic(fertilizerImageView);
            harvestButton.setGraphic(harvestImageView);
            plantGrassButton.setToggleGroup(actionToggleGroup);
            plantCarrotButton.setToggleGroup(actionToggleGroup);
            plantCabbageButton.setToggleGroup(actionToggleGroup);
            fertilizeButton.setToggleGroup(actionToggleGroup);
            harvestButton.setToggleGroup(actionToggleGroup);


            sleepButton.setOnAction(e->menuVM.sleepButtonAction());
            startButton.setOnAction(e -> this.onStartButtonAction());
            plantGrassButton.setOnAction(e -> {
                menuModeObjectProperty.set(Mode.PLANT_GRASS);
                this.onModeButtonAction(menuModeObjectProperty);});
            plantCarrotButton.setOnAction(e -> {
                menuModeObjectProperty.set(Mode.PLANT_CARROT);
                this.onModeButtonAction(menuModeObjectProperty);});
            plantCabbageButton.setOnAction(e -> {
                menuModeObjectProperty.set(Mode.PLANT_CABBAGE);
                this.onModeButtonAction(menuModeObjectProperty);});
            fertilizeButton.setOnAction(e -> { menuModeObjectProperty.set(Mode.FERTILIZE);
                this.onModeButtonAction(menuModeObjectProperty);});
            harvestButton.setOnAction(e -> { menuModeObjectProperty.set(Mode.HARVEST);
                this.onModeButtonAction(menuModeObjectProperty);});

            setFocusTraversable(false);
            startButton.setFocusTraversable(false);
            plantGrassButton.setFocusTraversable(false);
            plantCarrotButton.setFocusTraversable(false);
            plantCabbageButton.setFocusTraversable(false);
            fertilizeButton.setFocusTraversable(false);
            harvestButton.setFocusTraversable(false);
            getChildren().addAll(startButton, sleepButton, plantGrassButton, plantCarrotButton, plantCabbageButton, fertilizeButton, harvestButton);
        }

        private void onStartButtonAction() {
            if (startButton.getText().equals("Démarrer")) {
                menuVM.reset();
                sleepButton.setDisable(false);
                plantGrassButton.setDisable(false);
                plantCarrotButton.setDisable(false);
                plantCabbageButton.setDisable(false);
                fertilizeButton.setDisable(false);
                harvestButton.setDisable(false);
                plantGrassButton.setSelected(false);
                plantCarrotButton.setSelected(false);
                plantCabbageButton.setSelected(false);
                fertilizeButton.setSelected(false);
                harvestButton.setSelected(false);
                startButton.setText("Arrêter");
            } else {
                menuVM.stop();
                sleepButton.setDisable(true);
                plantGrassButton.setDisable(true);
                plantCarrotButton.setDisable(true);
                plantCabbageButton.setDisable(true);
                fertilizeButton.setDisable(true);
                harvestButton.setDisable(true);
                startButton.setText("Démarrer");
            }
        }
        private void onModeButtonAction(ObjectProperty<Mode> menuModeObjectProperty) {
            if (menuModeObjectProperty.get() == Mode.PLANT_GRASS) {
                plantCabbageButton.setSelected(false);
                plantCarrotButton.setSelected(false);
                fertilizeButton.setSelected(false);
                harvestButton.setSelected(false);
            } else if(menuModeObjectProperty.get() == Mode.PLANT_CARROT) {
                plantGrassButton.setSelected(false);
                plantCabbageButton.setSelected(false);
                fertilizeButton.setSelected(false);
                harvestButton.setSelected(false);
            } else if(menuModeObjectProperty.get() == Mode.PLANT_CABBAGE) {
                plantGrassButton.setSelected(false);
                plantCarrotButton.setSelected(false);
                fertilizeButton.setSelected(false);
                harvestButton.setSelected(false);
            } else if(menuModeObjectProperty.get() == Mode.FERTILIZE) {
                plantGrassButton.setSelected(false);
                plantCarrotButton.setSelected(false);
                plantCabbageButton.setSelected(false);
                harvestButton.setSelected(false);
            } else if(menuModeObjectProperty.get() == Mode.HARVEST) {
                plantGrassButton.setSelected(false);
                plantCarrotButton.setSelected(false);
                plantCabbageButton.setSelected(false);
                fertilizeButton.setSelected(false);
            }
            menuModeObjectProperty.set(actionToggleGroup.getSelectedToggle() == null ? Mode.FREE : menuModeObjectProperty.get());
        }
    }
