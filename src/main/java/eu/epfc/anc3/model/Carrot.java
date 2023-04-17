package eu.epfc.anc3.model;
class Carrot extends Element{
    Carrot() {
        elementType = ElementType.CARROT;
        stateProperty().set(new CarrotState1(this,StateType.STATE1,1));
        setIsVegetable(true);
    }

    @Override
    public Carrot getCopy() {
        Carrot copy = new Carrot();
        copy.setHasGrass(this.hasGrass());
        copy.setIsVegetable(this.getIsVegetable());
        copy.stateProperty().set(this.getState());
        return copy;
    }
}
