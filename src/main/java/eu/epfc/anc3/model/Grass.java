package eu.epfc.anc3.model;

class Grass extends Element {

    Grass() {
        elementType = ElementType.GRASS;
        stateProperty().set(new GrassState1(this,StateType.STATE1,1));
    }





}
