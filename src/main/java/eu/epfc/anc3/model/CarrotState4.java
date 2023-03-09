package eu.epfc.anc3.model;

import javafx.scene.image.Image;

class CarrotState4 implements CarrotState{

    int getCarrotState1Duration () {
        return CARROT_STATE4_DURATION;
    }

    double getCarrotState1PointPercentage() {
        return CARROT_STATE4_POINT_PERCENTAGE;
    }

    @Override
    public void updateImage() {
        imageView.setImage(new Image("carrot4.png"));
    }
}
