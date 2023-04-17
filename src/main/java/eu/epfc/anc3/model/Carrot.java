package eu.epfc.anc3.model;
class Carrot extends Element{
    Carrot() {
        elementType = ElementType.CARROT;
        stateProperty().set(new CarrotState1(this,StateType.STATE1,1));
        setIsVegetable(true);
    }


}
