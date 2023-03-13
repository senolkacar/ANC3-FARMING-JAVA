package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Grass extends Element {

    private int daysInCurrentState = 1;
    private StringProperty image = new SimpleStringProperty("grass.png");//
    private ObjectProperty<ImageType> imageTypeObjectProperty = new SimpleObjectProperty<>(ImageType.GRASS_IMAGE);

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
           this.setImageTypeObjectProperty(ImageType.NOIMAGE);
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

    @Override
    public ImageType getImageTypeObjectProperty() {
        return imageTypeObjectProperty.get();
    }

    @Override
    public ObjectProperty<ImageType> imageTypeObjectPropertyProperty() {
        return imageTypeObjectProperty;
    }

    @Override
    public void setImageTypeObjectProperty(ImageType imageTypeObjectProperty) {
        this.imageTypeObjectProperty.set(imageTypeObjectProperty);
    }
}
