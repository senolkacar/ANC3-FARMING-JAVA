package eu.epfc.anc3.model;

import javafx.beans.property.*;

import java.util.Objects;

public abstract class Element  {

    public ElementType elementType;
    private BooleanProperty isFertilied = new SimpleBooleanProperty();
    private BooleanProperty hasGrass = new SimpleBooleanProperty();
    private StringProperty image = new SimpleStringProperty("");//

    private ObjectProperty<ImageType> imageTypeObjectProperty = new SimpleObjectProperty<>();
    public ElementType getType() {
        return elementType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return elementType == element.elementType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementType);
    }

    public void incrementDay() {
    }

    @Override
    public String toString(){
        return elementType.toString();
    }

    public String getImage() {
        return image.get();
    }

    public StringProperty imageProperty() {
        return image;
    }

    public ImageType getImageTypeObjectProperty() {
        return imageTypeObjectProperty.get();
    }

    public ObjectProperty<ImageType> imageTypeObjectPropertyProperty() {
        return imageTypeObjectProperty;
    }

    public void setImageTypeObjectProperty(ImageType imageTypeObjectProperty) {
        this.imageTypeObjectProperty.set(imageTypeObjectProperty);
    }

    public void setIsFertilied(boolean isFertilied) {
        this.isFertilied.set(isFertilied);
    }

    public void fertilize(){
    }

    public void setHasGrass(boolean hasGrass) {
        this.hasGrass.set(hasGrass);
    }

    public void plantGrass(){
    }

    public IntegerProperty getHarvestScore(){
        return new SimpleIntegerProperty();
    }

    public void setElementHarvestScore(){}
}
