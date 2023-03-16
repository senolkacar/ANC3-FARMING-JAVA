package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.ImageView;

class CabbageState1 extends CabbageState{

    String image = "cabbage2.png";

    CabbageState1(Cabbage cabbage) {
        super(cabbage);
    }

    @Override
    void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE1_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE1_DURATION + 1)){
            cabbage.setCabbageState(new CabbageState2(cabbage));
            cabbage.setDaysInCurrentState(1);
            cabbage.setImage(image);
            cabbage.setStateType(StateType.STATE2);
        }
    }

    @Override
    void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE1_POINT_PERCENTAGE));
    }


    @Override
    public ObjectProperty<StateType> getStateType() {
        return cabbage.getStateType();
    }
}
