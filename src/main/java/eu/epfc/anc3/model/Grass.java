package eu.epfc.anc3.model;

class Grass extends Element {

    Grass() {
        elementType = ElementType.GRASS;
    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }
}
