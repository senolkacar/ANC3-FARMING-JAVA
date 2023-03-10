package eu.epfc.anc3.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotState2 extends CarrotState{

    ImageView imageView = new ImageView("carrot3.png");
    String image = "carrot3.png";

    int getCarrotState1Duration () {
        return CARROT_STATE2_DURATION;
    }

    double getCarrotState1PointPercentage() {
        return CARROT_STATE2_POINT_PERCENTAGE;
    }

    public CarrotState2(Carrot carrot) {
        super(carrot);
    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE2_DURATION + 1) {
            carrot.setCarrotState(new CarrotState3(carrot));
            carrot.setDaysInCurrentState(1);
           // carrot.setImageView(imageView);
            carrot.setImage(image);
        }
    }

    @Override
    public String toString() {
        return "CarrotState2{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }


}
