package eu.epfc.anc3.model;

class CabbageState3 extends ElementState {

    public CabbageState3(Element cabbage, StateType stateType, int daysInCurrentState) {
        super(cabbage,stateType,daysInCurrentState);
    }
    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_STATE3_DURATION
                || (!getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_STATE3_DURATION + 1)){
            getElement().stateProperty().set(new CabbageState4(getElement(),StateType.STATE4,1));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void setHarvestScore() {
        getHarvestScore().set((int)(MAX_POINTS_CABBAGE*CABBAGE_STATE3_POINT_PERCENTAGE));

    }

}
