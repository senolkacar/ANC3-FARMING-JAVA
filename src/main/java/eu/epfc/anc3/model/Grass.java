package eu.epfc.anc3.model;

class Grass extends Element {

    private int daysSincePlanting;
    Grass() {
        elementType = ElementType.GRASS;
        this.daysSincePlanting = 0;
    }

    @Override
    public void incrementDay() {
        daysSincePlanting++;
    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }


}
