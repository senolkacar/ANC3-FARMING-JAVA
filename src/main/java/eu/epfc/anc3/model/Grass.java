package eu.epfc.anc3.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Grass extends Element {

    private int daysInCurrentState = 1;
    private StringProperty image = new SimpleStringProperty("grass.png");

    Grass() {
        elementType = ElementType.GRASS;
    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }

    int getDaysInCurrentState() {
        return daysInCurrentState;
    }

    @Override
    public void incrementDay() {
        this.daysInCurrentState++;
        if (getDaysInCurrentState()==12+1) {
           this.setImage("0");
        }
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
