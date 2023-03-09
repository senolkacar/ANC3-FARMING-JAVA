package eu.epfc.anc3.model;

class Grass extends Element {

    private int daysInCurrentState = 1;

    Grass() {
        elementType = ElementType.GRASS;
    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }

    int getDaysInCurrentState() {
        return daysInCurrentState;
    }

    public void incrementDay() {
        this.daysInCurrentState++;
    }



}
