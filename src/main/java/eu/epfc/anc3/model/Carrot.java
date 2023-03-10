package eu.epfc.anc3.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;

public class Carrot extends Element{

    private CarrotState carrotState;
    private final int MAX_POINTS = 100;
    private int daysInCurrentState = 1;
    private ImageView imageView = new ImageView("carrot1.png");
    private StringProperty image = new SimpleStringProperty("carrot1.png");

    Carrot() {
        elementType = ElementType.CARROT;
        carrotState = new CarrotState1(this);
    }

    public CarrotState getCarrotState() {
        return carrotState;
    }

    public void setCarrotState(CarrotState carrotState) {
        this.carrotState = carrotState;
    }

    int getMAX_POINTS() {
        return MAX_POINTS;
    }

    int getDaysInCurrentState() {
        return daysInCurrentState;
    }

    public void setDaysInCurrentState(int daysInCurrentState) {
        this.daysInCurrentState = daysInCurrentState;
    }

    void incrementDaysInCurrentState() {
        this.daysInCurrentState++;
    }

    public void incrementDay() {
        incrementDaysInCurrentState();
        carrotState.incrementDay();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public String getImage() {
        return image.get();
    }

    public StringProperty imageProperty() {
        return image;
    }

    public void setImage(String image) {
        this.image.set(image);
    }
}
