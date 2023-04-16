package eu.epfc.anc3.model;

public class Cabbage extends Element{

    Cabbage() {
        elementType = ElementType.CABBAGE;
        state.set(new CabbageState1(this, StateType.STATE1,1));
        setIsVegetable(true);
    }

}
