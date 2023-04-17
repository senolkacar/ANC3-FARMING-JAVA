package eu.epfc.anc3.model;

class CarrotState1 extends ElementState {
    CarrotState1(Element carrot, StateType stateType,int daysInCurrentState) {
        super(carrot, stateType, daysInCurrentState);
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (getDaysInCurrentState() == CARROT_STATE1_DURATION + 1) {
            setStateType(StateType.STATE2);
            getElement().stateProperty().set(new CarrotState2(getElement(),StateType.STATE2,1));
            setDaysInCurrentState(1);
        }
    }
    @Override
    public void setHarvestScore() {
        getHarvestScore().set((int)(MAX_POINTS_CARROT*CARROT_STATE1_POINT_PERCENTAGE));
    }
    @Override
    public void fertilize(){
        setStateType(StateType.STATE3);
        getElement().stateProperty().set(new  CarrotState3(getElement(),StateType.STATE3,1));
        setDaysInCurrentState(1);
    }

}
