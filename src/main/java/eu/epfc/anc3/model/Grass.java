package eu.epfc.anc3.model;

class Grass extends Element {
    Grass() {
        elementType = ElementType.GRASS;
        stateProperty().set(new GrassState1(this,StateType.STATE1,1));
    }

    Grass(Grass grass) {
        this.elementType =grass.elementType;
        this.stateProperty().set(this.getState(grass.getState()));
    }

    private ElementState getState(State state) {
        return new GrassState1(this,state.getStateType().get(),state.getDaysInCurrentState());
    }

    @Override
    public Element getCopy() {
        return new Grass(this);
    }
}
