package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotRotten extends CarrotState{

   // String image = "0";

    CarrotRotten(Carrot carrot) {
        super(carrot);
        setStateType(StateType.STATEROTTEN);
    }

    @Override
    public void incrementDay() {
        if (getDaysInCurrentState() == CARROT_ROTTEN_DURATION + 1) {

            setDaysInCurrentState(getDaysInCurrentState()-1);//should be harvested. if not the method become recursive
            setHarvestScore();
            setStateType(StateType.STATE0);
        }
    }

    @Override
    public void setHarvestScore() {
        harvestScore.set(-(int)(carrot.getMAX_POINTS()*CARROT_STATE1_POINT_PERCENTAGE*getDaysInCurrentState()));
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return getStateType();
//    }

    @Override
    public void fertilize() {

    }
}
