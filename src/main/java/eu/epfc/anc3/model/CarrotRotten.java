package eu.epfc.anc3.model;

import javafx.scene.image.Image;

class CarrotRotten extends CarrotState{

    int getCarrotState1Duration () {
        return CARROT_ROTTEN_DURATION;
    }

    public CarrotRotten(Carrot carrot) {
        super(carrot);
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_ROTTEN_DURATION + 1) {
            carrot.setCarrotState(null);//?
            carrot.setDaysInCurrentState(0);
        }
    }
    
}
