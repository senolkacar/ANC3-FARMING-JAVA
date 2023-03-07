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

    private final ImageView carrot1 = new ImageView("carrot1.png");
    private final ImageView carrot2 = new ImageView("carrot2.png");
    private final ImageView carrot3 = new ImageView("carrot3.png");
    private final ImageView carrot4 = new ImageView("carrot4.png");
    private final ImageView rotten_carrot = new ImageView("rotten_carrot.png");

    private final ImageView cabbage1 = new ImageView("cabbage1.png");
    private final ImageView cabbage2 = new ImageView("cabbage2.png");
    private final ImageView cabbage3 = new ImageView("cabbage3.png");
    private final ImageView cabbage4 = new ImageView("cabbage4.png");
    private final ImageView rotten_cabbage = new ImageView("rotten_cabbage.png");
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
        carrot1.setFitHeight(35);
        carrot1.setFitWidth(35);
        carrot1.setPreserveRatio(true);
        cabbage1.setFitHeight(35);
        cabbage1.setFitWidth(35);
        cabbage1.setPreserveRatio(true);
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
        } else if (newList.contains(ElementType.DIRT)) {
            imageView.setImage(dirtImage);
            getChildren().remove(farmer);
        }
        if(newList.contains(ElementType.CARROT)){
            if(!getChildren().contains(carrot1)){
                getChildren().add(carrot1);
            }
        }else{
            getChildren().remove(carrot1);
        }
        if(newList.contains(ElementType.CABBAGE)){
            if(!getChildren().contains(cabbage1)){
                getChildren().add(cabbage1);
            }
        }else{
            getChildren().remove(cabbage1);
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
