package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.ImageView;

class CabbageState1 extends CabbageState{

    CabbageState1(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATE1);
    }
    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE1_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE1_DURATION + 1)){
            setStateType(StateType.STATE2);
            cabbage.setStateType(this.getStateType().get());
            cabbage.state = new CabbageState2(cabbage);

            //cabbage.state.setStateType(StateType.STATE2);
            cabbage.setDaysInCurrentState(1);
            //cabbage.setStateType(StateType.STATE2);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE1_POINT_PERCENTAGE));
    }

}
