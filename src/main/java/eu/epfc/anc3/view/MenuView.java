package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.GameViewModel;
import eu.epfc.anc3.vm.MenuViewModel;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MenuView extends HBox {
    private final Button startButton = new Button("Démarrer");
    private final Button plantButton = new Button("Planter du gazon");
    private final Button removeButton = new Button("Enlever du gazon");

    private final MenuViewModel menuViewModel;
    private final GameViewModel gameViewModel= new GameViewModel();

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
                FarmView farmView = new FarmView(gameViewModel.getFarmViewModel());//doesn't work ?
                farmView.setOnkeyPressed();//?
                farmView.requestFocus();
                startButton.setText("Areter");
            }
            else {
                menuViewModel.stop();
                startButton.setText("Démarrer");
            }
        });

//        if (startButton.getText().equals("Démarrer") ) {
//            startButton.setOnAction(e -> {
//                menuViewModel.start();
//                FarmView farmView = new FarmView(gameViewModel.getFarmViewModel());
//                farmView.requestFocus();
//                startButton.setText("Areter");
//            });
//        } else {
//            startButton.setOnAction(e -> {
//                menuViewModel.stop();
//                startButton.setText("Démarrer");
//            });
//        }
    }










}
