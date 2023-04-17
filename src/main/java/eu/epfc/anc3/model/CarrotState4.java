package eu.epfc.anc3.model;

class CarrotState4 extends ElementState {
    CarrotState4(Element carrot, StateType stateType,int daysInCurrentState) {
        super(carrot,stateType,1);
    }
    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (getDaysInCurrentState() == CARROT_STATE4_DURATION + 1) {
            setStateType(StateType.STATEROTTEN);
            getElement().stateProperty().set(new  CarrotRotten(getElement(),StateType.STATEROTTEN,1));
            setDaysInCurrentState(1);
        }
    }
    @Override
    public void setHarvestScore() {
        getHarvestScore().set((int)(MAX_POINTS_CARROT*CARROT_STATE4_POINT_PERCENTAGE));
    }


}
