package eu.epfc.anc3.model;

class Cabbage extends Element{

    Cabbage() {
        elementType = ElementType.CABBAGE;
        stateProperty().set(new CabbageState1(this, StateType.STATE1,1));
        setIsVegetable(true);
    }

}
