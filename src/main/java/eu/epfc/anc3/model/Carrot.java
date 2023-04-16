package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class Carrot extends Element{

    Carrot() {
        elementType = ElementType.CARROT;
        state.set(new CarrotState1(this,StateType.STATE1,1));
        setIsVegetable(true);
    }


}
