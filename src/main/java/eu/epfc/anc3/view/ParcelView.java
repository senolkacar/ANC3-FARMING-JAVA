package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Element;
import eu.epfc.anc3.model.ElementType;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.property.ListProperty;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.List;
import java.util.stream.Collectors;

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
        setAlignment(farmer, Pos.TOP_LEFT);

        ListProperty<Element> valueProperty = parcelViewModel.valueProperty();
        valueProperty.addListener((obs, old, newVal) -> this.setElementsImages(imageView, newVal));

        setOnMouseClicked(e -> parcelViewModel.onMouseClicked());
    }

    void setElementsImages(ImageView imageView, List<Element> elements) {
        List<ElementType> newList = elements.stream().map(Element::getType).collect(Collectors.toList());
        if (newList.contains(ElementType.GRASS)){
            imageView.setImage(grassImage);
            getChildren().remove(farmer);
        } else {
            imageView.setImage(dirtImage);
            getChildren().remove(farmer);

        }
        if (newList.contains(ElementType.FARMER)) {
            getChildren().remove(farmer);
            getChildren().add(farmer);

        }
//                for (Element element : elements) {
//                    if(element.getType()== ElementType.GRASS){
//                        imageView.setImage(grassImage);
//                        getChildren().remove(farmer);
//                    }else if(element.getType()== ElementType.DIRT){
//                        imageView.setImage(dirtImage);
//                        getChildren().remove(farmer);
//                    }
//                 }
//
//                for (Element element : elements) {
//                    if(element.getType()== ElementType.FARMER){
//                        getChildren().remove(farmer);
//                        getChildren().add(farmer);
//                    }
//                }
    }




}
