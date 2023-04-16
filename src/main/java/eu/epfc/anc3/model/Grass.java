package eu.epfc.anc3.model;

class Grass extends Element {

    //private int daysInCurrentState = 1;

    Grass() {
        elementType = ElementType.GRASS;
        state.set(new GrassState1(this,StateType.STATE1,1));
    }

//    @Override
//    public ElementType getType() {
//        return this.elementType;
//    }
//
//    int getDaysInCurrentState() {
//        return daysInCurrentState;
//    }
//
//    @Override
//    void incrementDay() {
//        this.daysInCurrentState++;
//        state.get().incrementDay();
//    }




}
