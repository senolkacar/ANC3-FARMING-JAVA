package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotRotten extends CarrotState{

    String image = "0";
    int getCarrotState1Duration () {
        return CARROT_ROTTEN_DURATION;
    }

    public CarrotRotten(Carrot carrot) {
        super(carrot);
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_ROTTEN_DURATION + 1) {
            carrot.setImage(image);
            carrot.setHarvestScore(-carrot.getMAX_POINTS());
            carrot.setStateType(StateType.STATE0);
        }
    }

    @Override
    public void setHarvestScore() {
        carrot.setHarvestScore(-(int)(carrot.getMAX_POINTS()*CARROT_STATE1_POINT_PERCENTAGE*carrot.getDaysInCurrentState()));
    }

    @Override
    public ObjectProperty<StateType> getStateType() {
        return carrot.getStateType();
    }
}
