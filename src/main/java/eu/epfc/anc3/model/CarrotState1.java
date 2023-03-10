package eu.epfc.anc3.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CarrotState1 extends CarrotState{
    ImageView imageView = new ImageView("carrot2.png");
    String image = "carrot2.png";

    public CarrotState1(Carrot carrot) {
        super(carrot);
    }
//
//    int getCarrotState1Duration () {
//        return CARROT_STATE1_DURATION;
//    }
//
//    double getCarrotState1PointPercentage() {
//      return CARROT_STATE1_POINT_PERCENTAGE;
//    }

    @Override
    public void incrementDay() {
        if (carrot.getDaysInCurrentState() == CARROT_STATE1_DURATION + 1) {
            carrot.setCarrotState(new CarrotState2(carrot));
            carrot.setDaysInCurrentState(1);
            //carrot.setImageView(imageView);
            carrot.setImage(image);
        }
    }

    @Override
    public void setHarvestScore() {
        carrot.setHarvestScore((int)(carrot.getMAX_POINTS()*CARROT_STATE1_POINT_PERCENTAGE));
    }

    public void fertilize(){
        carrot.setCarrotState(new CarrotState3(carrot));
        carrot.setDaysInCurrentState(1);
        carrot.setImage("carrot3.png");
    }

    @Override
    public String toString() {
        return "CarrotState1{" +
                "carrot=" + carrot +"stateDays=" + carrot.getDaysInCurrentState()+
                '}';
    }


}
