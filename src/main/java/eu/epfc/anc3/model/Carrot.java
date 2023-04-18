package eu.epfc.anc3.model;

class Carrot extends Element {
    Carrot() {
        elementType = ElementType.CARROT;
        stateProperty().set(new CarrotState1(this, StateType.STATE1, 1));
        setIsVegetable(true);
    }

    public Carrot(Carrot other) {
        elementType = other.elementType;
        setIsVegetable(other.getIsVegetable());
        stateProperty().set(this.getState(other.getState())); // Or use other.getStateProperty().get().clone() if you want a deep copy of the state property
    }

    private ElementState getState(State state) {
        if (state.getStateType().get() == StateType.STATE1) {
            return new CarrotState1(this, state.getStateType().get(), state.getDaysInCurrentState());
        } else if (state.getStateType().get() == StateType.STATE2) {
            return new CarrotState2(this, state.getStateType().get(), state.getDaysInCurrentState());
        } else if (state.getStateType().get() == StateType.STATE3) {
            return new CarrotState3(this, state.getStateType().get(), state.getDaysInCurrentState());
        } else if (state.getStateType().get() == StateType.STATE4) {
            return new CarrotState4(this, state.getStateType().get(), state.getDaysInCurrentState());
        } else if (state.getStateType().get() == StateType.STATEROTTEN) {
            return new CarrotRotten(this, state.getStateType().get(), state.getDaysInCurrentState());
        } else {
            return null;
        }
    }

    @Override
    public Element getCopy() {
        return new Carrot(this);
    }
}
