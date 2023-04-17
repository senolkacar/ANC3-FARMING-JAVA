package eu.epfc.anc3.model;

class CabbageState4 extends ElementState {

    public CabbageState4(Element cabbage, StateType stateType, int daysInCurrentState) {
        super(cabbage,stateType,daysInCurrentState);

    }
    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        if (getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_STATE4_DURATION
                || (!getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_STATE4_DURATION + 1)){
            getElement().stateProperty().set(new CabbageRotten(getElement(),StateType.STATEROTTEN,1));
            setDaysInCurrentState(1);

        }
    }

    @Override
    public void setHarvestScore() {
        getHarvestScore().set((int)(MAX_POINTS_CABBAGE*CABBAGE_STATE4_POINT_PERCENTAGE));

    }

}
