package eu.epfc.anc3.model;

class Cabbage extends Element{
    Cabbage() {
        elementType = ElementType.CABBAGE;
        stateProperty().set(new CabbageState1(this, StateType.STATE1,1));
        setIsVegetable(true);
    }


    public Cabbage(Cabbage other) {
        elementType = other.elementType;
        setIsVegetable(other.getIsVegetable());
        stateProperty().set(this.getState(other.getState())); // Or use other.getStateProperty().get().clone() if you want a deep copy of the state property
    }
    private ElementState getState(State state) {
        if(state.getStateType().get() == StateType.STATE1) {
            return new CabbageState1(this, state.getStateType().get(), state.getDaysInCurrentState());
        }else if(state.getStateType().get() == StateType.STATE2){
            return new CabbageState2(this,state.getStateType().get(),state.getDaysInCurrentState());
        }else if(state.getStateType().get() == StateType.STATE3){
            return new CabbageState3(this,state.getStateType().get(),state.getDaysInCurrentState());
        }else if(state.getStateType().get() == StateType.STATE4) {
            return new CabbageState4(this,state.getStateType().get(),state.getDaysInCurrentState());
        }else if(state.getStateType().get() == StateType.STATEROTTEN){
            return new CabbageRotten(this,state.getStateType().get(),state.getDaysInCurrentState());
        }else{
            return null;
        }
    }

    @Override
    public Element getCopy() {
        return new Cabbage(this);
    }
}
