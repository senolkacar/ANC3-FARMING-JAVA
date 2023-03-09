package eu.epfc.anc3.model;

import javafx.scene.image.Image;

class CarrotRotten implements CarrotState{

    int getCarrotState1Duration () {
        return CARROT_ROTTEN_DURATION;
    }

    @Override
    public void updateImage() {
        imageView.setImage(new Image("rotten_carrot.png"));
    }
    
}
