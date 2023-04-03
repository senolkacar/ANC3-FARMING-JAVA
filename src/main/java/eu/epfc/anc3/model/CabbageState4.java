package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageState4 extends CabbageState {
    CabbageState4(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATE4);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE4_DURATION
                || (!cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE4_DURATION + 1)){
            cabbage.setElementState(new CabbageRotten(cabbage));
            setDaysInCurrentState(1);
            setStateType(StateType.STATEROTTEN);
        }
    }
    @Override
    public void setHarvestScore() {
       harvestScore.set((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE4_POINT_PERCENTAGE));
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return getStateType();
//    }

    @Override
    public void fertilize() {

    }
}
