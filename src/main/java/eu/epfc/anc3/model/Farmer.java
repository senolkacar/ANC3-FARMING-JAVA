package eu.epfc.anc3.model;

class Farmer extends Element{

    private Position position;

    Farmer() {
        elementType = ElementType.FARMER;
    }

    Position getPosition() {
        return position;
    }

    void setPosition(Position position) {
        this.position = position;
    }
}
