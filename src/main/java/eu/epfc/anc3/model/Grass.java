package eu.epfc.anc3.model;

class Grass extends Element {

    private int daysSincePlanting;
    Grass() {
        elementType = ElementType.GRASS;
        this.daysSincePlanting = 0;
    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }


}
