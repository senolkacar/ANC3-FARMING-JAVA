package eu.epfc.anc3.model;

class Farmer extends Element{

    private Position position;

    Farmer() {
        elementType = ElementType.FARMER;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
