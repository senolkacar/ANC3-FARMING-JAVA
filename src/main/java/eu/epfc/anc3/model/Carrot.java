package eu.epfc.anc3.model;
class Carrot extends Element{
    Carrot() {
        elementType = ElementType.CARROT;
        stateProperty().set(new CarrotState1(this,StateType.STATE1,1));
        setIsVegetable(true);
    }

    @Override
    public Carrot getCopy() {
        Carrot copy = new Carrot();
        copy.setHasGrass(this.hasGrass());
         copy.setIsVegetable(this.getIsVegetable());
        copy.stateProperty().set(this.getState());
        return copy;

        //return new Carrot(this);
    }

    Carrot(Carrot copy) {
        this.setHasGrass(copy.hasGrass());
        this.setIsVegetable(copy.getIsVegetable());
        this.stateProperty().set(this.stateProperty().get());
        System.out.println(this.getState());
        //this.stateProperty().set(copy.getState(copy.getState()));
    }

    private ElementState getState(State state) {
        if (state instanceof CarrotState1) {
            return new CarrotState1(this, ((CarrotState1) state).getStateType().get(), ((CarrotState1) state).getDaysInCurrentState());
        } else if (state instanceof CarrotState2) {
            return new CarrotState2(this, ((CarrotState2) state).getStateType().get(), ((CarrotState2) state).getDaysInCurrentState());
        } else if (state instanceof CarrotState3) {
            return new CarrotState3(this, ((CarrotState3) state).getStateType().get(), ((CarrotState3) state).getDaysInCurrentState());
        }else if (state instanceof CarrotState4) {
            return new CarrotState4(this, ((CarrotState4) state).getStateType().get(), ((CarrotState4) state).getDaysInCurrentState());
        }else if (state instanceof CarrotRotten) {
            return new CarrotRotten(this, ((CarrotRotten) state).getStateType().get(), ((CarrotRotten) state).getDaysInCurrentState());
        }else {
            return null;
        }
    }
}
