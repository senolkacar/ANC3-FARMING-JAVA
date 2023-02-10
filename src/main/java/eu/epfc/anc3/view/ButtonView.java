package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.ButtonViewModel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import static eu.epfc.anc3.view.GameView.*;

public class ButtonView extends HBox {
    private final Button startButton = new Button();
    private final Button stopButton = new Button();
    private final Button plantButton = new Button();
    private final Button removeButton = new Button();

    private final ButtonViewModel buttonViewModel;

    public ButtonView(ButtonViewModel buttonViewModel){
        this.buttonViewModel = buttonViewModel;
        configButtons();
        manageStartButton();
        manageStopButton();
    }
    private void configButtons(){
    setPadding(new Insets(PADDING));
    startButton.textProperty().bind(buttonViewModel.startButtonProperty());
    stopButton.textProperty().bind(buttonViewModel.stopButtonProperty());
    plantButton.textProperty().bind(buttonViewModel.plantButtonProperty());
    removeButton.textProperty().bind(buttonViewModel.removeButtonProperty());
    getChildren().addAll(startButton, stopButton, plantButton, removeButton);
    }

    private void manageStartButton(){
        startButton.setOnAction(event -> {
            buttonViewModel.start();
        });
    }

    private void manageStopButton(){
        stopButton.setOnAction(event -> {
            buttonViewModel.stop();
        });
    }

}
