package eu.epfc.anc3.model;

import javafx.scene.image.Image;

class CarrotState3 implements CarrotState{

    int getCarrotState1Duration () {
        return CARROT_STATE3_DURATION;
    }

    double getCarrotState1PointPercentage() {
        return CARROT_STATE3_POINT_PERCENTAGE;
    }

    @Override
    public void updateImage() {
        imageView.setImage(new Image("carrot3.png"));
    }
}
