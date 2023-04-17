package eu.epfc.anc3.model;

class CabbageRotten extends ElementState {
    public CabbageRotten(Element cabbage, StateType stateType, int daysInCurrentState) {
        super(cabbage,stateType,daysInCurrentState);
    }
    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        setHarvestScore();
        if (getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -5
                || (!getElement().hasGrass() && getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION+1)){
            if(!getElement().hasGrass()){
                setDaysInCurrentState(getDaysInCurrentState()-1);
            }
            getElement().stateProperty().set(new CabbageRotten(getElement(),StateType.STATE0,getDaysInCurrentState()));
            setStateType(StateType.STATE0);
            setHarvestScore();
        }
    }
    @Override
    public void setHarvestScore() {
        getHarvestScore().set(-(int)(MAX_POINTS_CABBAGE* 0.1 *getDaysInCurrentState()));
    }

}
