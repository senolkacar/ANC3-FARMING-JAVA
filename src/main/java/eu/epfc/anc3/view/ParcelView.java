package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Element;
import eu.epfc.anc3.model.ElementType;
import eu.epfc.anc3.model.StateType;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.List;
import java.util.stream.Collectors;

public class ParcelView extends StackPane {
    private final ParcelViewModel parcelVM;
    private final ImageView imageView = new ImageView();
    private final ImageView farmer = new ImageView("farmer.png");
    private final ImageView carrot = new ImageView("carrot1.png");
    private final ImageView cabbage = new ImageView("cabbage1.png");

    private static final Image grassImage = new Image("grass.png");
    private static final Image dirtImage = new Image("dirt.png");

    private static final Image carrot1 = new Image("carrot1.png");
    private static final Image carrot2 = new Image("carrot2.png");
    private static final Image carrot3 = new Image("carrot3.png");
    private static final Image carrot4 = new Image("carrot4.png");
    private static final Image rotten_carrot = new Image("rotten_carrot.png");

    private static final Image cabbage1 = new Image("cabbage1.png");
    private static final Image cabbage2 = new Image("cabbage2.png");
    private static final Image cabbage3 = new Image("cabbage3.png");
    private static final Image cabbage4 = new Image("cabbage4.png");
    private static final Image rotten_cabbage = new Image("rotten_cabbage.png");

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
            for(Element element : elements) {
                if(element.getType() == ElementType.GRASS) {
                    if (element.getState() != null) {
                        element.getState().getStateType().addListener((obs, oldVal, newVal) -> setGrassImage(newVal));
                    }
                }
            }
        } else if (newList.contains(ElementType.DIRT)) {
            imageView.setImage(dirtImage);
            getChildren().remove(farmer);
        }

        if (newList.contains(ElementType.CARROT)) {
           for(Element element : elements) {
                if(element.getType() == ElementType.CARROT) {
                    setCarrotImage(element.stateProperty().get().getStateType().get(),element);
                    if (!getChildren().contains(carrot)) {
                        getChildren().add(carrot);
                        getChildren().remove(farmer);
                    }

                    if (element.stateProperty() != null) {
                        element.stateProperty().addListener((obs, oldVal, newVal) -> {
                               setCarrotImage(newVal.getStateType().get(),element);
                        });
                    }
                }
            }
        } else {
            getChildren().remove(carrot);
            carrot.setImage(carrot1);
            getChildren().remove(farmer);
        }

        if (newList.contains(ElementType.CABBAGE)) {
            for (Element element : elements) {
                if (element.getType() == ElementType.CABBAGE) {
                    setCabbageImage(element.stateProperty().get().getStateType().get(),element);
                    if (!getChildren().contains(cabbage)) {
                        getChildren().add(cabbage);
                        getChildren().remove(farmer);
                    }
                    if (element.stateProperty() != null) {
                        element.stateProperty().addListener((obs, oldVal, newVal) -> {
                            setCabbageImage(newVal.getStateType().get(),element);
                        });
                    }
                }
            }
        } else {
            getChildren().remove(cabbage);
            cabbage.setImage(cabbage1);
            getChildren().remove(farmer);
        }

        if (newList.contains(ElementType.FARMER)) {
            getChildren().remove(farmer);
            getChildren().add(farmer);
        }
    }

    private void setCarrotImage(StateType stateType,Element element) {
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
        if(getChildren().contains(farmer)){
            getChildren().remove(farmer);
            getChildren().add(farmer);
        }

        if (stateType == StateType.STATE0) {
            getChildren().remove(carrot);
            carrot.setImage(carrot1);
            parcelVM.autoHarvest(ElementType.CARROT);
        }

    }

    private void setCabbageImage(StateType stateType,Element element) {
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
        if(getChildren().contains(farmer)){
            getChildren().remove(farmer);
            getChildren().add(farmer);
        }

        if (stateType == StateType.STATE0) {
            getChildren().remove(cabbage);
            cabbage.setImage(cabbage1);
            parcelVM.autoHarvest(ElementType.CABBAGE);
        }
    }

    private void setGrassImage(StateType stateType) {
        imageView.setImage(dirtImage);
        switch (stateType) {
            case STATE1:
                imageView.setImage(grassImage);
                break;
            case STATE0:
                imageView.setImage(dirtImage);
                parcelVM.autoHarvest(ElementType.GRASS);
                break;
        }

    }
}