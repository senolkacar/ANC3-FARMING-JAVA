package eu.epfc.anc3.model;

class CabbageState2 extends ElementState {
    public CabbageState2(Element cabbage, StateType stateType, int daysInCurrentState) {
        super(cabbage, stateType, daysInCurrentState);
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState() + 1);
        if (getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_STATE2_DURATION
                || (!getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_STATE2_DURATION + 1)) {
            getElement().stateProperty().set(new CabbageState3(getElement(), StateType.STATE3, 1));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void setHarvestScore() {
        getHarvestScore().set((int) (MAX_POINTS_CABBAGE * CABBAGE_STATE2_POINT_PERCENTAGE));
    }

}
