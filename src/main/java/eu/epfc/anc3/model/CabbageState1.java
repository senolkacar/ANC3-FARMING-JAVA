package eu.epfc.anc3.model;

class CabbageState1 extends ElementState {
    CabbageState1(Element cabbage, StateType stateType, int daysInCurrentState) {
        super(cabbage, stateType, daysInCurrentState);
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState() + 1);
        if (getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_STATE1_DURATION
                || (!getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_STATE1_DURATION + 1)) {
            getElement().stateProperty().set(new CabbageState2(getElement(), StateType.STATE2, 1));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void setHarvestScore() {
        getHarvestScore().set((int) (MAX_POINTS_CABBAGE * CABBAGE_STATE1_POINT_PERCENTAGE));
    }

}
