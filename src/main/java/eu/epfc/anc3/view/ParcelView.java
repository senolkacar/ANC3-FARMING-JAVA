package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Element;
import eu.epfc.anc3.model.ElementType;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.property.IntegerProperty;
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
        carrot2.setFitHeight(35);
        carrot2.setFitWidth(35);
        carrot2.setPreserveRatio(true);
        carrot3.setFitHeight(35);
        carrot3.setFitWidth(35);
        carrot3.setPreserveRatio(true);
        carrot4.setFitHeight(35);
        carrot4.setFitWidth(35);
        carrot4.setPreserveRatio(true);
        rotten_carrot.setFitHeight(35);
        rotten_carrot.setFitWidth(35);
        rotten_carrot.setPreserveRatio(true);
        cabbage1.setFitHeight(35);
        cabbage1.setFitWidth(35);
        cabbage1.setPreserveRatio(true);
        cabbage2.setFitHeight(35);
        cabbage2.setFitWidth(35);
        cabbage2.setPreserveRatio(true);
        cabbage3.setFitHeight(35);
        cabbage3.setFitWidth(35);
        cabbage3.setPreserveRatio(true);
        cabbage4.setFitHeight(35);
        cabbage4.setFitWidth(35);
        cabbage4.setPreserveRatio(true);
        rotten_cabbage.setFitHeight(35);
        rotten_cabbage.setFitWidth(35);
        rotten_cabbage.setPreserveRatio(true);
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
        if (newList.contains(ElementType.CARROT)) {
            int carrotState = 0;
            for (Element element : elements) {
                if (element.getType() == ElementType.CARROT) {
                    carrotState = element.getState();
                    element.getStateProperty().addListener((obs, oldVal, newVal) -> setElementsImages(imageView, elements));
                    break;
                }
            }
            switch (carrotState) {
                case 1:
                    if (!getChildren().contains(carrot1)) {
                        getChildren().add(carrot1);
                    }
                    getChildren().removeAll(carrot2, carrot3, carrot4, rotten_carrot);
                    break;
                case 2:
                    if (!getChildren().contains(carrot2)) {
                        getChildren().add(carrot2);
                    }
                    getChildren().removeAll(carrot1, carrot3, carrot4, rotten_carrot);
                    break;
                case 3:
                    if (!getChildren().contains(carrot3)) {
                        getChildren().add(carrot3);
                    }
                    getChildren().removeAll(carrot1, carrot2, carrot4, rotten_carrot);
                    break;
                case 4:
                    if (!getChildren().contains(carrot4)) {
                        getChildren().add(carrot4);
                    }
                    getChildren().removeAll(carrot2, carrot3, carrot1, rotten_carrot);
                    break;
                case 5:
                    if (!getChildren().contains(rotten_carrot)) {
                        getChildren().add(rotten_carrot);
                    }
                    getChildren().removeAll(carrot2, carrot3, carrot1, carrot4);
                    break;
                default:
                    getChildren().removeAll(carrot1,carrot2, carrot3, carrot4, rotten_carrot);
                    break;
            }
        } else {
            getChildren().removeAll(carrot1,carrot2, carrot3, carrot4, rotten_carrot);
        }

        if (newList.contains(ElementType.CABBAGE)) {
            int cabbageState = 0;
            for (Element element : elements) {
                if (element.getType() == ElementType.CABBAGE) {
                    cabbageState = element.getState();
                    element.getStateProperty().addListener((obs, oldVal, newVal) -> setElementsImages(imageView, elements));
                    break;
                }
            }
            switch (cabbageState){
                case 1:
                    if (!getChildren().contains(cabbage1)) {
                        getChildren().add(cabbage1);
                    }
                    getChildren().removeAll(cabbage2, cabbage3, cabbage4, rotten_cabbage);
                    break;
                case 2:
                    if (!getChildren().contains(cabbage2)) {
                        getChildren().add(cabbage2);
                    }
                    getChildren().removeAll(cabbage1, cabbage3, cabbage4, rotten_cabbage);
                    break;
                case 3:
                    if (!getChildren().contains(cabbage3)) {
                        getChildren().add(cabbage3);
                    }
                    getChildren().removeAll(cabbage1, cabbage2, cabbage4, rotten_cabbage);
                    break;
                case 4:
                    if (!getChildren().contains(cabbage4)) {
                        getChildren().add(cabbage4);
                    }
                    getChildren().removeAll(cabbage2, cabbage3, cabbage1, rotten_cabbage);
                    break;
                case 5:
                    if (!getChildren().contains(rotten_cabbage)) {
                        getChildren().add(rotten_cabbage);
                    }
                    getChildren().removeAll(cabbage2, cabbage3, cabbage1, cabbage4);
                    break;
                default:
                    getChildren().removeAll(cabbage1,cabbage2, cabbage3, cabbage4, rotten_cabbage);
                    break;
            }
        } else {
            getChildren().removeAll(cabbage1,cabbage2, cabbage3, cabbage4, rotten_cabbage);
        }
        if (newList.contains(ElementType.FARMER)) {
            getChildren().remove(farmer);
            getChildren().add(farmer);
        }
    }




}
