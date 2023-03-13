package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Carrot;
import eu.epfc.anc3.model.Element;
import eu.epfc.anc3.model.ElementType;
import eu.epfc.anc3.model.ImageType;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.property.*;
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
    private ObjectProperty<ImageType> imageTypeObjectProperty = new SimpleObjectProperty<>();

    private final ImageView imageView = new ImageView();
    private final Image grassImage = new Image("grass.png");
    private final Image dirtImage = new Image("dirt.png");
    private final ImageView farmer = new ImageView("farmer.png");
    private final ImageView carrot = new ImageView("carrot1.png");
    private final ImageView cabbage = new ImageView("cabbage1.png");

    private final Image carrot1 = new Image("carrot1.png");
    private final Image carrot2 = new Image("carrot2.png");//static
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
        this.setElementsImages(imageView, parcelViewModel.valueProperty().getValue());

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

        ObjectProperty<ImageType> imageTypeObjectProperty =parcelViewModel.imageTypeObjectPropertyProperty();

        imageTypeObjectProperty.addListener((obs, old, newVal) ->configureImage(newVal));

        ListProperty<Element> valueProperty = parcelViewModel.valueProperty();

        valueProperty.addListener((obs, old, newVal) ->{
            this.setElementsImages(imageView, newVal);
        } );

        setOnMouseClicked(e -> parcelViewModel.onMouseClicked());
    }

    private void configureImage(ImageType imageType) { //static
        if (imageType != null) {
            switch (imageType) {
//                case GRASS_IMAGE:
//                    imageView.setImage(grassImage);
//                    break;
//                case NOIMAGE:
//                    imageView.setImage(dirtImage);//new carrot/cabbage image empty
//                    break;
                case CARROT_STATE1_IMAGE:
                    carrot.setImage(carrot1);
                    break;
                case CARROT_STATE2_IMAGE:
                    carrot.setImage(carrot2);
                    break;
                case CARROT_STATE3_IMAGE:
                    carrot.setImage(carrot3);
                    break;
                case CARROT_STATE4_IMAGE:
                    carrot.setImage(carrot4);
                    break;
                case CARROT_STATEROTTEN_IMAGE:
                    carrot.setImage(rotten_carrot);
                    break;
                case CABBAGE_STATE1_IMAGE:
                    cabbage.setImage(cabbage1);
                    break;
                case CABBAGE_STATE2_IMAGE:
                    cabbage.setImage(cabbage2);
                    break;
                case CABBAGE_STATE3_IMAGE:
                    cabbage.setImage(cabbage3);
                    break;
                case CABBAGE_STATE4_IMAGE:
                    cabbage.setImage(cabbage4);
                    break;
                case CABBAGE_STATEROTTEN_IMAGE:
                    cabbage.setImage(rotten_cabbage);
                    break;

            }
        }

    }



    void setElementsImages(ImageView imageView, List<Element> elements ) {

        imageTypeObjectProperty.addListener((obs, old, newVal) ->configureImage(newVal));

        List<ElementType> newList = elements.stream().map(Element::getType).collect(Collectors.toList());

        if (newList.contains(ElementType.GRASS)) {
            imageView.setImage(grassImage);
            getChildren().remove(farmer);
//
//            List<Element> list = elements.stream().filter(e->e.elementType==ElementType.GRASS).limit(1).collect(Collectors.toList());
//            if (list.size()>0 && imageTypeObjectProperty != null) {
//                imageTypeObjectProperty.addListener((obs, oldVal, newVal) -> configureImage(new SimpleObjectProperty<>(newVal)));
//            }

        } else if (newList.contains(ElementType.DIRT)) {
            imageView.setImage(dirtImage);
            getChildren().remove(farmer);
        }

        if (newList.contains(ElementType.CARROT)) {
            List<Element> list = elements.stream().filter(e->e.elementType==ElementType.CARROT).limit(1).collect(Collectors.toList());
//            if (list.size()>0){
//                carrot.setImage(new Image(list.get(0).imageProperty().get()));
//                if (!getChildren().contains(carrot)) {
//                    getChildren().add(carrot);
//                    getChildren().remove(farmer);
//                }
//                list.get(0).imageProperty().addListener((obs, oldVal, newVal) -> setCarrotImage(imageView, newVal));// carrot public ?
//            }
            if (list.size()>0){

                getChildren().remove(carrot);
                getChildren().add(carrot);
                getChildren().remove(farmer);

                System.out.println(imageTypeObjectProperty);
               // imageTypeObjectProperty.addListener((obs, oldVal, newVal) -> configureImage(new SimpleObjectProperty<>(newVal)));
            }

        }

        if (newList.contains(ElementType.CABBAGE)) {
            List<Element> list = elements.stream().filter(e->e.elementType==ElementType.CABBAGE).limit(1).collect(Collectors.toList());
            if (list.size()>0){
                if (!getChildren().contains(cabbage)) {
                    getChildren().add(cabbage);
                    getChildren().remove(farmer);
                }
                //imageTypeObjectProperty.addListener((obs, oldVal, newVal) -> configureImage(new SimpleObjectProperty<>(newVal)));
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




}
