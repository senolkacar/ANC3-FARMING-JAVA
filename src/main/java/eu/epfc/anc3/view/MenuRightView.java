    package eu.epfc.anc3.view;

    import eu.epfc.anc3.model.Mode;
    import eu.epfc.anc3.vm.MenuRightViewModel;
    import eu.epfc.anc3.vm.MenuViewModel;
    import javafx.beans.property.ObjectProperty;
    import javafx.beans.property.SimpleObjectProperty;
    import javafx.scene.control.Button;
    import javafx.scene.control.ToggleButton;
    import javafx.scene.control.ToggleGroup;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;

    public class MenuRightView extends VBox {


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
//
        private final MenuRightViewModel menuRightVM;
//        ObjectProperty<Mode> menuModeObjectProperty = new SimpleObjectProperty<>();

        public MenuRightView(MenuRightViewModel menuRightVM) {
            this.menuRightVM = menuRightVM;
           // menuModeObjectProperty.bindBidirectional(menuVM.gameModeProperty());

            actionToggleGroup = new ToggleGroup();

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


//
//            plantGrassButton.setOnAction(e -> {
//                menuModeObjectProperty.set(Mode.PLANT_GRASS);
//                this.onModeButtonAction(menuModeObjectProperty);});
//            plantCarrotButton.setOnAction(e -> {
//                menuModeObjectProperty.set(Mode.PLANT_CARROT);
//                this.onModeButtonAction(menuModeObjectProperty);});
//            plantCabbageButton.setOnAction(e -> {
//                menuModeObjectProperty.set(Mode.PLANT_CABBAGE);
//                this.onModeButtonAction(menuModeObjectProperty);});
//            fertilizeButton.setOnAction(e -> { menuModeObjectProperty.set(Mode.FERTILIZE);
//                this.onModeButtonAction(menuModeObjectProperty);});
//            harvestButton.setOnAction(e -> { menuModeObjectProperty.set(Mode.HARVEST);
//                this.onModeButtonAction(menuModeObjectProperty);});

            setFocusTraversable(false);

            plantGrassButton.setFocusTraversable(false);
            plantCarrotButton.setFocusTraversable(false);
            plantCabbageButton.setFocusTraversable(false);
            fertilizeButton.setFocusTraversable(false);
            harvestButton.setFocusTraversable(false);
            getChildren().addAll(plantGrassButton, plantCarrotButton, plantCabbageButton, fertilizeButton, harvestButton);
        }

    }
