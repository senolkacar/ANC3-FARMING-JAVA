package eu.epfc.anc3.model;

import javafx.scene.image.Image;

class CarrotState2 implements CarrotState{

    int getCarrotState1Duration () {
        return CARROT_STATE2_DURATION;
    }

    double getCarrotState1PointPercentage() {
        return CARROT_STATE2_POINT_PERCENTAGE;
    }

    @Override
    public void updateImage() {
        imageView.setImage(new Image("carrot2.png"));
    }
}
