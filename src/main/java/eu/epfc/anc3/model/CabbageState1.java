package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.ImageView;

class CabbageState1 extends VegetableState{

    CabbageState1(Element cabbage, StateType stateType, int daysInCurrentState) {
        super(cabbage,stateType,daysInCurrentState);
    }
    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        if (element.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE1_DURATION
                || (!element.hasGrass() && getDaysInCurrentState() == CABBAGE_STATE1_DURATION + 1)){
            element.state.set(new CabbageState2(element,StateType.STATE2,1));
            setDaysInCurrentState(1);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(MAX_POINTS_CABBAGE*CABBAGE_STATE1_POINT_PERCENTAGE));

    }

}
