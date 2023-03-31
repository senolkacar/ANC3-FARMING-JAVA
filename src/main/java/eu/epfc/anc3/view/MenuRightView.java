    package eu.epfc.anc3.view;

    import eu.epfc.anc3.model.Mode;
    import eu.epfc.anc3.vm.MenuRightViewModel;
    import eu.epfc.anc3.vm.MenuViewModel;
    import javafx.beans.property.BooleanProperty;
    import javafx.beans.property.ObjectProperty;
    import javafx.beans.property.SimpleObjectProperty;
    import javafx.geometry.Insets;
    import javafx.scene.control.Button;
    import javafx.scene.control.Toggle;
    import javafx.scene.control.ToggleButton;
    import javafx.scene.control.ToggleGroup;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;

    public class MenuRightView extends VBox {
        private final static int SPACE = 10;
        private final static int BUTTON_WIDTH = 180;
        private final static int BUTTON_HEIGHT = 50;

        private final ToggleGroup actionToggleGroup;

        private final ToggleButton plantGrassButton = new ToggleButton("Planter du gazon");
        private final ToggleButton plantCarrotButton =new ToggleButton("Planter des carottes");
        private final ToggleButton plantCabbageButton =new ToggleButton("Planter du chou");
        private final ToggleButton fertilizeButton =new ToggleButton("Fertiliser");
        private final ToggleButton harvestButton =new ToggleButton("Récolter");

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

        private final MenuRightViewModel menuRightVM;
        ObjectProperty<Mode> menuModeObjectProperty = new SimpleObjectProperty<>();
        BooleanProperty farmerMovementEnableProperty ;

        public MenuRightView(MenuRightViewModel menuRightVM) {
            this.setSpacing(SPACE);
            this.setPadding(new Insets(20));
            
            this.menuRightVM = menuRightVM;
            menuModeObjectProperty.bindBidirectional(menuRightVM.gameModeProperty());
            farmerMovementEnableProperty = menuRightVM.farmerMovementEnableProperty();

            configLogicBinding();

            actionToggleGroup = new ToggleGroup();

            plantGrassButton.setPrefWidth(BUTTON_WIDTH);
            plantGrassButton.setPrefWidth(BUTTON_WIDTH);
            plantCarrotButton.setPrefWidth(BUTTON_WIDTH);
            plantCarrotButton.setPrefWidth(BUTTON_WIDTH);
            plantCabbageButton.setPrefWidth(BUTTON_WIDTH);
            plantCabbageButton.setPrefWidth(BUTTON_WIDTH);
            fertilizeButton.setPrefWidth(BUTTON_WIDTH);
            fertilizeButton.setPrefWidth(BUTTON_WIDTH);
            harvestButton.setPrefWidth(BUTTON_WIDTH);
            harvestButton.setPrefWidth(BUTTON_WIDTH);

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

            plantGrassButton.setOnAction(e -> {
                this.pantGrassAction(menuModeObjectProperty);});
            plantCarrotButton.setOnAction(e -> {
                this.plantCarrotAction(menuModeObjectProperty);});
            plantCabbageButton.setOnAction(e -> {
                this.plantCabbageAction(menuModeObjectProperty);});
            fertilizeButton.setOnAction(e -> {
                this.fertilizeAction(menuModeObjectProperty);});
            harvestButton.setOnAction(e -> {
                this.harvestAction(menuModeObjectProperty);});

            getChildren().addAll(plantGrassButton, plantCarrotButton, plantCabbageButton, fertilizeButton, harvestButton);
        }

        private void configLogicBinding() {
            plantGrassButton.disableProperty().bind(menuRightVM.farmerMovementEnableProperty().not());
            plantCabbageButton.disableProperty().bind(menuRightVM.farmerMovementEnableProperty().not());
            plantCarrotButton.disableProperty().bind(menuRightVM.farmerMovementEnableProperty().not());
            fertilizeButton.disableProperty().bind(menuRightVM.farmerMovementEnableProperty().not());
            harvestButton.disableProperty().bind(menuRightVM.farmerMovementEnableProperty().not());

            farmerMovementEnableProperty.addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    Toggle toggle = actionToggleGroup.getSelectedToggle();
                    if (toggle != null) {
                        actionToggleGroup.getToggles().forEach(tg -> (toggle).setSelected(false));
                    }

                }
            });
        }



        private void harvestAction(ObjectProperty<Mode> menuModeObjectProperty) {
            requestFocus();
            if (menuModeObjectProperty.get()==Mode.HARVEST){
                menuRightVM.setGameMode(Mode.FREE);
            } else{
                menuRightVM.setGameMode(Mode.HARVEST);
                harvestButton.isSelected();

            }
        }

        private void fertilizeAction(ObjectProperty<Mode> menuModeObjectProperty) {
            requestFocus();
            if (menuModeObjectProperty.get()==Mode.FERTILIZE){
                menuRightVM.setGameMode(Mode.FREE);
            } else{
                menuRightVM.setGameMode(Mode.FERTILIZE);
                fertilizeButton.isSelected();

            }

        }

        private void plantCabbageAction(ObjectProperty<Mode> menuModeObjectProperty) {
            requestFocus();
            if (menuModeObjectProperty.get()==Mode.PLANT_CABBAGE){
                menuRightVM.setGameMode(Mode.FREE);
            } else{
                menuRightVM.setGameMode(Mode.PLANT_CABBAGE);
                plantCabbageButton.isSelected();
            }
        }

        private void plantCarrotAction(ObjectProperty<Mode> menuModeObjectProperty) {
            requestFocus();
            if (menuModeObjectProperty.get()==Mode.PLANT_CARROT){
                menuRightVM.setGameMode(Mode.FREE);
            } else{
                menuRightVM.setGameMode(Mode.PLANT_CARROT);
                plantCarrotButton.isSelected();
            }
        }

        private void pantGrassAction(ObjectProperty<Mode> menuModeObjectProperty) {
            requestFocus();
            if (menuModeObjectProperty.get()==Mode.PLANT_GRASS){
                menuRightVM.setGameMode(Mode.FREE);
            } else{
                menuRightVM.setGameMode(Mode.PLANT_GRASS);
                plantGrassButton.isSelected();

            }

        }





    }
