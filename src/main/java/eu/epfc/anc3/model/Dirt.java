package eu.epfc.anc3.model;

class Dirt extends Element {
    Dirt() {
        elementType = ElementType.DIRT;
    }

    @Override
    public Element getCopy() {
        return this;
    }
}
