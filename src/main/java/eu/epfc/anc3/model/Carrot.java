package eu.epfc.anc3.model;

class Carrot extends Element{

    private CarrotState carrotState;

    Carrot() {
        elementType = ElementType.CARROT;
        carrotState = new CarrotState1();
    }

    CarrotState getCarrotState() {
        return carrotState;
    }

    void setCarrotState(CarrotState carrotState) {
        this.carrotState = carrotState;
    }

}
