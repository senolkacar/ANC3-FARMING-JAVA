package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotRotten extends CarrotState{

    CarrotRotten(Carrot carrot, StateType stateType) {
        super(carrot,stateType);
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return stateType;
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_ROTTEN_DURATION + 1) {
            carrot.setDaysInCurrentState(carrot.getDaysInCurrentState()-1);//should be harvested. if not the method become recursive
            carrot.setElementHarvestScore();
            carrot.state.setStateType(StateType.STATE0);
            carrot.setStateType(this.getStateType().get());
            //stateType.set(StateType.STATE0);
        }
    }

    @Override
    public void fertilize() {

    }

    @Override
    public void setHarvestScore() {
        carrot.setHarvestScore(-(int)(carrot.getMAX_POINTS()*CARROT_STATE1_POINT_PERCENTAGE*carrot.getDaysInCurrentState()));
    }

}
