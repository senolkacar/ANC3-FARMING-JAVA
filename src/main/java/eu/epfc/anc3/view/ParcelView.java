package eu.epfc.anc3.view;

import eu.epfc.anc3.model.ElementValue;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class ParcelView extends StackPane {

    private final ImageView imageView = new ImageView();
    private final Image grassImage = new Image("grass.png");
    private final ImageView grass = new ImageView("grass.png");
    private final Image dirtImage = new Image("dirt.png");
    private final ImageView farmer = new ImageView("farmer.png");

    public ParcelView(ParcelViewModel parcelViewModel) {
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(false);
        this.setElementsImages(imageView, ElementValue.DIRT);

        getChildren().add(imageView);

        farmer.setFitWidth(50);
        farmer.setFitHeight(50);
        farmer.setPreserveRatio(true);

        ObjectProperty<ElementValue> valueProperty = parcelViewModel.valueProperty();
        valueProperty.addListener((obs, old, newVal) -> this.setElementsImages(imageView, newVal));

        setOnMouseClicked(e -> parcelViewModel.onMouseClicked());


    }

    private void setElementsImages(ImageView imageView, ElementValue value) {
        switch (value) {
            case DIRT:
                imageView.setImage(dirtImage);
                getChildren().remove(farmer);
                break;
            case GRASS:
                imageView.setImage(grassImage);
                getChildren().remove(farmer);
            case DIRT_AND_FARMER:
//                imageView.setImage(dirtImage);
//                getChildren().add(grass);
//                getChildren().remove(grass);
//                getChildren().remove(farmer); // TODO why ?
//                getChildren().add(farmer);
            case GRASS_AND_FARMER:
                imageView.setImage(grassImage);
                getChildren().remove(farmer); // TODO why ?
                getChildren().add(farmer);
        }
    }
}
