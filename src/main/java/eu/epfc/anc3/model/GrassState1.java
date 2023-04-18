package eu.epfc.anc3.model;

public class GrassState1 extends ElementState {
    GrassState1(Element grass, StateType stateType, int daysInCurentState) {
        super(grass, stateType, 1);
    }

    @Override
    public void setStateType(StateType stateType) {
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState() + 1);
        if (getDaysInCurrentState() == 12 + 1) {
            getStateType().set(StateType.STATE0);
        }
    }

}
