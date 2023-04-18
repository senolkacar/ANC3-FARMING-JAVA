package eu.epfc.anc3.model;

class CarrotState3 extends ElementState {
    CarrotState3(Element carrot, StateType stateType, int daysInCurrentState) {
        super(carrot, stateType, 1);
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState() + 1);
        if (getDaysInCurrentState() == CARROT_STATE3_DURATION + 1) {
            setStateType(StateType.STATE4);
            getElement().stateProperty().set(new CarrotState4(getElement(), StateType.STATE4, 1));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void setHarvestScore() {
        getHarvestScore().set((int) (MAX_POINTS_CARROT * CARROT_STATE3_POINT_PERCENTAGE));
    }


}
