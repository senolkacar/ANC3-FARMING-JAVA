package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Carrot;
import eu.epfc.anc3.model.Element;
import eu.epfc.anc3.model.ElementType;
import eu.epfc.anc3.model.StateType;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParcelView extends StackPane {

    private final ParcelViewModel parcelVM;

    private final ImageView imageView = new ImageView();
    private final Image grassImage = new Image("grass.png");
    private final Image dirtImage = new Image("dirt.png");
    private final ImageView farmer = new ImageView("farmer.png");
    private final ImageView carrot = new ImageView("carrot1.png");
    private final ImageView cabbage = new ImageView("cabbage1.png");

    private final Image carrot1 = new Image("carrot1.png");
    private final Image carrot2 = new Image("carrot2.png");
    private final Image carrot3 = new Image("carrot3.png");
    private final Image carrot4 = new Image("carrot4.png");
    private final Image rotten_carrot = new Image("rotten_carrot.png");

    private final Image cabbage1 = new Image("cabbage1.png");
    private final Image cabbage2 = new Image("cabbage2.png");
    private final Image cabbage3 = new Image("cabbage3.png");
    private final Image cabbage4 = new Image("cabbage4.png");
    private final Image rotten_cabbage = new Image("rotten_cabbage.png");

    public ParcelView(ParcelViewModel parcelViewModel) {
        parcelVM = parcelViewModel;
        imageView.setFitWidth(35);
        imageView.setFitHeight(35);
        imageView.setPreserveRatio(false);


        getChildren().add(imageView);

        farmer.setFitWidth(35);
        farmer.setFitHeight(35);
        farmer.setPreserveRatio(true);
        setAlignment(farmer, Pos.TOP_LEFT);

        carrot.setFitHeight(35);
        carrot.setFitWidth(35);
        carrot.setPreserveRatio(true);

        cabbage.setFitHeight(35);
        cabbage.setFitWidth(35);
        cabbage.setPreserveRatio(true);


        ListProperty<Element> valueProperty = parcelViewModel.valueProperty();
        this.setElementsImages(imageView, valueProperty);
        valueProperty.addListener((obs, old, newVal) -> {
            this.setElementsImages(imageView, newVal);
        });

        setOnMouseClicked(e -> parcelViewModel.onMouseClicked());
    }

    private void setElementsImages(ImageView imageView, ObservableList<Element> elements) {
        List<ElementType> newList = elements.stream().map(Element::getType).collect(Collectors.toList());

        if (newList.contains(ElementType.GRASS)) {
            imageView.setImage(grassImage);
            getChildren().remove(farmer);
            List<Element> list = elements.stream().filter(e -> e.elementType == ElementType.GRASS).limit(1).collect(Collectors.toList());
            if (list.size() > 0) {
                list.get(0).getStateType().addListener((obs, oldVal, newVal) -> {
                    setGrassImage(newVal);
                });
            }

        } else if (newList.contains(ElementType.DIRT)) {
            imageView.setImage(dirtImage);
            getChildren().remove(farmer);
        }

        if (newList.contains(ElementType.CARROT)) {
            List<Element> list = elements.stream().filter(e -> e.elementType == ElementType.CARROT).limit(1).collect(Collectors.toList());
            if (list.size() > 0) {
                carrot.setImage(new Image(list.get(0).imageProperty().get()));
                if (!getChildren().contains(carrot)) {
                    getChildren().add(carrot);
                    getChildren().remove(farmer);
                }
                list.get(0).getStateType().addListener((obs, oldVal, newVal) -> setCarrotImage(newVal));// carrot public ?
            }
        } else {
            getChildren().remove(carrot);
            getChildren().remove(farmer);
        }

        if (newList.contains(ElementType.CABBAGE)) {
            List<Element> list = elements.stream().filter(e -> e.elementType == ElementType.CABBAGE).limit(1).collect(Collectors.toList());
            if (list.size() > 0) {
                carrot.setImage(new Image(list.get(0).imageProperty().get()));
                if (!getChildren().contains(carrot)) {
                    getChildren().add(carrot);
                    getChildren().remove(farmer);
                }
                list.get(0).getStateType().addListener((obs, oldVal, newVal) -> setCabbageImage(newVal));
            }
        } else {
            getChildren().remove(cabbage);
            getChildren().remove(farmer);
        }

        if (newList.contains(ElementType.FARMER)) {
            getChildren().remove(farmer);
            getChildren().add(farmer);
        }

    }


    private void setCarrotImage(StateType stateType) {
        getChildren().remove(carrot);

        switch (stateType) {
            case STATE1:
                carrot.setImage(carrot1);
                break;
            case STATE2:
                carrot.setImage(carrot2);
                break;
            case STATE3:
                carrot.setImage(carrot3);
                break;
            case STATE4:
                carrot.setImage(carrot4);
                break;
            case STATEROTTEN:
                carrot.setImage(rotten_carrot);
                break;
        }
        getChildren().add(carrot);

        if (stateType == StateType.STATE0) {
            getChildren().remove(carrot);
            parcelVM.removeElement(ElementType.CARROT);
        }

    }

    private void setCabbageImage(StateType stateType) {
        getChildren().remove(cabbage);

        switch (stateType) {
            case STATE1:
                cabbage.setImage(cabbage1);
                break;
            case STATE2:
                cabbage.setImage(cabbage2);
                break;
            case STATE3:
                cabbage.setImage(cabbage3);
                break;
            case STATE4:
                cabbage.setImage(cabbage4);
                break;
            case STATEROTTEN:
                cabbage.setImage(rotten_cabbage);
                break;
        }
        getChildren().add(cabbage);

        if (stateType == StateType.STATE0) {
            getChildren().remove(cabbage);
            parcelVM.removeElement(ElementType.CABBAGE);
        }
    }

    private void setGrassImage(StateType stateType) {
        imageView.setImage(dirtImage);
        switch (stateType) {
            case STATE1:
                cabbage.setImage(grassImage);
                break;
            case STATE0:
                cabbage.setImage(dirtImage);
                parcelVM.removeElement(ElementType.GRASS);
                break;

        }


    }
}