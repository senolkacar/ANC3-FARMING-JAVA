package eu.epfc.anc3.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CarrotState1 implements CarrotState{

    int getCarrotState1Duration () {
        return CARROT_STATE1_DURATION;
    }

    double getCarrotState1PointPercentage() {
      return CARROT_STATE1_POINT_PERCENTAGE;
    }


    @Override
    public void updateImage() {
        imageView.setImage(new Image("carrot1.png"));
    }
}
