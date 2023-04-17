package eu.epfc.anc3.model;

class CarrotRotten extends ElementState {
    CarrotRotten(Element carrot, StateType stateType,int daysInCurrentState) {
        super(carrot,stateType,daysInCurrentState);
    }
    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        setHarvestScore();
        if (getDaysInCurrentState() == CARROT_ROTTEN_DURATION + 1) {
            setDaysInCurrentState(getDaysInCurrentState()-1);//should be harvested. if not the method become recursive

            getElement().stateProperty().set(new CarrotRotten(getElement(),StateType.STATE0,getDaysInCurrentState()));
            setStateType(StateType.STATE0);
            setHarvestScore();
        }
    }
    @Override
    public void setHarvestScore() {
        getHarvestScore().set(-(int)(MAX_POINTS_CARROT*CARROT_STATE1_POINT_PERCENTAGE*getDaysInCurrentState()));
    }

}
