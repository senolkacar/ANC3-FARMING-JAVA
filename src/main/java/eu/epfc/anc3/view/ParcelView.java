package eu.epfc.anc3.view;

import eu.epfc.anc3.model.ParcelValue;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ParcelView extends StackPane {

    private static final Image dirtImage = new Image("dirt.png");
    private static final Image farmerImage = new Image("farmer.png");
    private static final Image grassImage = new Image("grass.png");

    private final ImageView imageView = new ImageView();

    public ParcelView(DoubleBinding parcelWidthProperty){//only for test
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(parcelWidthProperty);
        imageView.setImage(dirtImage);
        getChildren().add(imageView);

    }

    public ParcelView(ParcelViewModel parcelViewModel, DoubleBinding parcelWidthProperty){
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(parcelWidthProperty);

        getChildren().add(imageView);

        ReadOnlyObjectProperty<ParcelValue> valueProp = parcelViewModel.valueProperty();
        valueProp.addListener((obs,old,newVal)->setFarmImage(imageView,newVal));
    }

    private void setFarmImage(ImageView imageView,ParcelValue parcelValue){
        imageView.setImage(parcelValue == ParcelValue.DIRT
                ? dirtImage
                : grassImage
        );
    }
}
