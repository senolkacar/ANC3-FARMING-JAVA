package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

abstract class GrassState implements State {

    protected Grass grass;
    public ObjectProperty<StateType> stateType = new SimpleObjectProperty<>();

    GrassState(Grass grass, StateType stateType) {
        this.grass = grass;
        this.stateType.set(stateType);

    }


}
