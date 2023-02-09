package eu.epfc.anc3.view;

import eu.epfc.anc3.model.ParcelValue;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ParcelView extends StackPane {

    private static final Image dirtImage = new Image("dirt.png");
    private static final Image farmerImage = new Image("farmer.png");
    private static final Image grassImage = new Image("grass.png");

    private ImageView imageView = new ImageView(dirtImage);
    private ImageView farmerImageView = new ImageView();

    public ParcelView(){//only for test
        setPadding(Insets.EMPTY);
        //imageView.setPreserveRatio(true);
        //imageView.fitWidthProperty().bind(parcelWidthProperty);
        imageView.fitHeightProperty().bind(heightProperty());
        imageView.fitWidthProperty().bind(widthProperty());
        //imageView.setImage(dirtImage);
        getChildren().add(imageView);

    }

    public ParcelView(Image farmerImage){
        this();
        farmerImageView.setImage(farmerImage);
        farmerImageView.setFitWidth(50);
        farmerImageView.setFitHeight(50);
        farmerImageView.setPreserveRatio(true);
        setAlignment(farmerImageView, Pos.TOP_LEFT);
        getChildren().add(farmerImageView);

    }
    public ParcelView(ParcelViewModel parcelViewModel){
        setPadding(Insets.EMPTY);
        imageView.fitHeightProperty().bind(heightProperty());
        imageView.fitWidthProperty().bind(widthProperty());
        getChildren().add(imageView);

//        ReadOnlyObjectProperty<ParcelValue> valueProp = parcelViewModel.valueProperty();
//        valueProp.addListener((obs,old,newVal)->setFarmImage(imageView,newVal));
 //   this.setOnMouseClicked(e -> parcelViewModel.teleportFarmer());
    }

    private void setFarmImage(ImageView farmerImageView,ParcelValue parcelValue){
        imageView.setImage(parcelValue == ParcelValue.DIRT
                ? dirtImage
                : grassImage
        );
    }
}
