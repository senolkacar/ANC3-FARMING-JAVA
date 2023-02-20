package eu.epfc.anc3.model;

class Grass extends Element {

    Grass() {
        type = Type.GRASS;
    }
    @Override
    public Type getType() {
        return this.type;
    }
}
