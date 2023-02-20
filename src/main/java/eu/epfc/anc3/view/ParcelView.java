package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Element;
import eu.epfc.anc3.model.ElementValue;
import eu.epfc.anc3.model.Type;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SetProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.List;
import java.util.Set;

public class ParcelView extends StackPane {

    private final ImageView imageView = new ImageView();
    private final Image grassImage = new Image("grass.png");
    private final Image dirtImage = new Image("dirt.png");
    private final ImageView farmer = new ImageView("farmer.png");

    public ParcelView(ParcelViewModel parcelViewModel) {
        imageView.setFitWidth(35);
        imageView.setFitHeight(35);
        imageView.setPreserveRatio(false);
        this.setElementsImages(imageView, parcelViewModel.valueProperty().getValue());

        getChildren().add(imageView);

        farmer.setFitWidth(35);
        farmer.setFitHeight(35);
        farmer.setPreserveRatio(true);

        ListProperty<Element> valueProperty = parcelViewModel.valueProperty();
        valueProperty.addListener((obs, old, newVal) -> this.setElementsImages(imageView, newVal));

        setOnMouseClicked(e -> parcelViewModel.onMouseClicked());


    }

    private void setElementsImages(ImageView imageView, List<Element> elements) {
                for (Element element : elements) {
                    if(element.getType()==Type.DIRT){
                        imageView.setImage(dirtImage);
                        getChildren().remove(farmer);
                    }
                    if(element.getType()==Type.GRASS){
                        imageView.setImage(grassImage);
                        getChildren().remove(farmer);
                    }
                    if(element.getType()==Type.FARMER){
                        getChildren().remove(farmer);
                        getChildren().add(farmer);
                }
            }
    }
}
