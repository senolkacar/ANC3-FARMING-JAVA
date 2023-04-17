package eu.epfc.anc3.model;

class CarrotState2 extends ElementState {

    CarrotState2(Element carrot, StateType stateType,int daysInCurrentState) {
        super(carrot, stateType,1);

    }


    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (getDaysInCurrentState() == CARROT_STATE2_DURATION + 1) {
            setStateType(StateType.STATE3);
            getElement().stateProperty().set(new CarrotState3(getElement(),StateType.STATE3,1 ));
            setDaysInCurrentState(1);
        }
    }
    @Override
    public void fertilize(){
        setStateType(StateType.STATE3);
        getElement().stateProperty().set(new CarrotState3(getElement(), StateType.STATE3,1));
        setDaysInCurrentState(1);
    }

    @Override
    public void setHarvestScore() {
        getHarvestScore().set((int)(MAX_POINTS_CARROT*CARROT_STATE2_POINT_PERCENTAGE));
    }



}
