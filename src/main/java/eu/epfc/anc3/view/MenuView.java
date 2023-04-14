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

        private final MenuViewModel menuVM;
        ObjectProperty<Mode> menuModeObjectProperty = new SimpleObjectProperty<>();

        public MenuView(MenuViewModel menuVM) {
            this.setSpacing(50);
            this.setPadding(new Insets(20));

            this.menuVM = menuVM;
            menuModeObjectProperty.bindBidirectional(menuVM.gameModeProperty());

            startButton = new Button();
            sleepButton = new Button();
            startButton.setFocusTraversable(false);
            sleepButton.setFocusTraversable(false);
            //sleepButton.setDisable(true);

            buttonNameLogic();
            buttonLogic();

            sleepButton.setOnAction(e->{
                menuVM.sleepButtonAction();
                requestFocus();
            });
            startButton.setOnAction(e -> {
                requestFocus();
                menuVM.OnStartButtonAction();});

            getChildren().addAll(startButton, sleepButton);
        }

        private void buttonNameLogic() {
            startButton.textProperty().bind(menuVM.startButtonTextProperty());
            sleepButton.textProperty().bind(menuVM.sleepButtonTextProperty());
        }

        private void buttonLogic(){
            sleepButton.disableProperty().bind(menuVM.farmerMovementEnableProperty().not());
        }
        /*private void onStartButtonAction() {

            if (startButton.getText().equals("Démarrer")) {
                menuVM.reset();
                sleepButton.setDisable(false);
                startButton.setText("Arrêter");
            } else {
                menuVM.stop();
                sleepButton.setDisable(true);
                startButton.setText("Démarrer");
            }

        }*/
    }
