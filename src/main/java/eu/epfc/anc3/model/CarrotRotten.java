package eu.epfc.anc3.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotRotten extends CarrotState{

    ImageView imageView = new ImageView();
    String image = "";
    int getCarrotState1Duration () {
        return CARROT_ROTTEN_DURATION;
    }

    public CarrotRotten(Carrot carrot) {
        super(carrot);
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_ROTTEN_DURATION + 1) {
            //carrot.setCarrotState(null);//?
            carrot.setDaysInCurrentState(0);
            //carrot.setImageView(imageView);
            carrot.setImage(image);

        }
    }

}
