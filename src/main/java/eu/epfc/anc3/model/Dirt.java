package eu.epfc.anc3.model;

class Dirt extends Element {
    Dirt() {
        type = Type.DIRT;
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
