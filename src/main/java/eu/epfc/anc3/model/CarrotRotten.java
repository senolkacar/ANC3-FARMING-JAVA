package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotRotten extends VegetableState{

    CarrotRotten(Element carrot, StateType stateType,int daysInCurrentState) {
        super(carrot,stateType,daysInCurrentState);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        setDaysInCurrentState(getDaysInCurrentState()+1);
        setHarvestScore();
        if (getDaysInCurrentState() == CARROT_ROTTEN_DURATION + 1) {
            setDaysInCurrentState(getDaysInCurrentState()-1);//should be harvested. if not the method become recursive

            element.state.set(new CarrotRotten(element,StateType.STATE0,getDaysInCurrentState()));
            setStateType(StateType.STATE0);
            setHarvestScore();
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        harvestScore.set(-(int)(MAX_POINTS_CARROT*CARROT_STATE1_POINT_PERCENTAGE*getDaysInCurrentState()));
    }

    @Override
    public String toString() {
        return "CarrotRotten{" +
                "element=" + element +
                ", daysInCurrentState=" + daysInCurrentState +
                ", stateType=" + stateType +
                ", harvestScore=" + harvestScore +
                '}';
    }
}
