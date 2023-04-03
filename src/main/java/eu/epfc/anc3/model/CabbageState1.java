package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.ImageView;

class CabbageState1 extends CabbageState{

    CabbageState1(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATE1);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE1_DURATION
                || (!cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE1_DURATION + 1)){
            cabbage.setElementState(new CabbageState2(cabbage));
            setDaysInCurrentState(1);
            setStateType(StateType.STATE2);
        }
    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE1_POINT_PERCENTAGE));
    }


//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return getStateType();
//    }

    @Override
    public void fertilize() {

    }
}
