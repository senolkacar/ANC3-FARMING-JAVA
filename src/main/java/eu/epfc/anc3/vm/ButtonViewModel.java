package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;

public class ButtonViewModel {
    private final GameFacade game;

    public ButtonViewModel(GameFacade game) {
        this.game = game;
    }

    public void start() {
        game.start();
    }

    public void stop() {
        game.stop();
    }



    public ReadOnlyStringProperty startButtonProperty() {
        return new SimpleStringProperty("Start");
    }
    public ReadOnlyStringProperty stopButtonProperty() {
        return new SimpleStringProperty("Stop");
    }
    public ReadOnlyStringProperty plantButtonProperty() {
        return new SimpleStringProperty("Planter gazon");
    }
    public ReadOnlyStringProperty removeButtonProperty() {
        return new SimpleStringProperty("Enlever gazon");
    }
}
