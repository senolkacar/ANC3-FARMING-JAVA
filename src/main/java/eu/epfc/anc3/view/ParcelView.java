package eu.epfc.anc3.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class ParcelView extends StackPane {

    private final int[] coordinates;
    boolean isDirt;

    private ImageView farmer; //  pass it through the viewModel instead of here

    public ParcelView(int[] coordinates) {
        this.requestFocus();
        this.coordinates = coordinates;

        setPadding(Insets.EMPTY);

        farmer = new ImageView(new Image("farmer.png"));
        farmer.setFitWidth(50);
        farmer.setFitHeight(50);
        farmer.setPreserveRatio(true);
        displayDirt();
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setMyBackground(String png) {
        this.setBackground(new Background(
                new BackgroundImage(new Image(png), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }

    public void displayDirt() {
        isDirt = true;
        this.setMyBackground("dirt.png");
    }

    public void displayGrass() {
        isDirt = false;
        this.setMyBackground("grass.png");
    }

    public void putFarmer() {
        getChildren().add(farmer);
        setAlignment(farmer, Pos.CENTER);
    }

    public void removeFarmer() {
        getChildren().remove(farmer);
    }


}
