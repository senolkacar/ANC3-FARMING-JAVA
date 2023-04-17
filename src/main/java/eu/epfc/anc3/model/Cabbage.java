package eu.epfc.anc3.model;

class Cabbage extends Element{
    Cabbage() {
        elementType = ElementType.CABBAGE;
        stateProperty().set(new CabbageState1(this, StateType.STATE1,1));
        setIsVegetable(true);
    }

    Cabbage(Cabbage copy) {
        this.setHasGrass(copy.hasGrass());
        this.setIsVegetable(copy.getIsVegetable());
        //this.stateProperty().set(copy.getState(copy.getState()));
        this.stateProperty().set(this.stateProperty().get());
        System.out.println(this.getState());
    }
    @Override
    public Cabbage getCopy() {
        System.out.println("copy cabbage");
        Cabbage copy = new Cabbage();
        copy.setHasGrass(this.hasGrass());
        copy.setIsVegetable(this.getIsVegetable());
        copy.stateProperty().set(this.getState());
        return copy;
        //return new Cabbage(this);
    }

    private ElementState getState(State state) {
        if (state instanceof CabbageState1) {
            return new CabbageState1(this, ((CabbageState1) state).getStateType().get(), ((CabbageState1) state).getDaysInCurrentState());
        } else if (state instanceof CabbageState2) {
            return new CabbageState2(this, ((CabbageState2) state).getStateType().get(), ((CabbageState2) state).getDaysInCurrentState());
        } else if (state instanceof CabbageState3) {
            return new CabbageState3(this, ((CabbageState3) state).getStateType().get(), ((CabbageState3) state).getDaysInCurrentState());
        }else if (state instanceof CabbageState4) {
            return new CabbageState4(this, ((CabbageState4) state).getStateType().get(), ((CabbageState4) state).getDaysInCurrentState());
        }else if (state instanceof CabbageRotten) {
            return new CabbageRotten(this, ((CabbageRotten) state).getStateType().get(), ((CabbageRotten) state).getDaysInCurrentState());
        }else {
            return null;
        }
    }


}
