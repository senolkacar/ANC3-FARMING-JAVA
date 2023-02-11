package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Mode;
import eu.epfc.anc3.vm.FarmViewModel;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.HashMap;
import java.util.Map;

import static eu.epfc.anc3.view.GameView.FARM_HEIGHT;//
import static eu.epfc.anc3.view.GameView.FARM_WIDTH;
import static eu.epfc.anc3.view.GameView.PADDING;

public class FarmView extends GridPane {
    private final Map<Integer, Map<Integer, ParcelView>> parcels; // to put in the model
    private int[] farmerCoordinates; // to put in the model
    FarmViewModel farmViewModel;

    public FarmView(FarmViewModel farmViewModel) {// FarmView(FarmViewModel farmViewModel, DoubleProperty farmWidthProperty, DoubleProperty farmHeightProperty)
//        setHgap(0);
//        setVgap(0);
//        setGridLinesVisible(true);
        setPadding(new Insets(PADDING));
        this.farmViewModel = farmViewModel;

        for (int i = 0; i < 25; ++i) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0 / FARM_WIDTH);
            getColumnConstraints().add(columnConstraints);
        }
        for (int j = 0; j < 15; j++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0 / FARM_HEIGHT);
            getRowConstraints().add(rowConstraints);
        }

        parcels = new HashMap<>();

        for (int i = 0; i < FARM_WIDTH; ++i) {
            HashMap<Integer, ParcelView> ithRow = new HashMap();
            parcels.put(i, ithRow);
            for (int j = 0; j < FARM_HEIGHT; ++j) {
                ParcelView parcelView = new ParcelView(new int[]{i, j});//position (col, line)
                //parcelView.displayDirt();
                if (i == 0 && j == 0) {
                    parcelView.putFarmer();
                    farmerCoordinates = new int[]{0, 0};//initial farmerCordinates
                }
                if (farmViewModel.gameModeProperty().get() != Mode.FREE) {
                    parcelView.setOnMouseClicked(e -> this.handleTeleport((ParcelView) e.getSource()));
                }
                add(parcelView, i, j);//add(parcelView, i, j); col, line
                ithRow.put(j, parcelView);
            }
        }
    }

    private void removeFarmer() {
        parcels.get(farmerCoordinates[0]).get(farmerCoordinates[1]).removeFarmer();//old farmerCoordinates
    }

    private void putFarmer() {
        ParcelView parcel = parcels.get(farmerCoordinates[0]).get(farmerCoordinates[1]);
        parcel.putFarmer();
//        if (!parcel.isDirt)
//        parcels.get(farmerCoordinates[0]).get(farmerCoordinates[1]).displayDirt(); // only for testing
//        else
//        parcels.get(farmerCoordinates[0]).get(farmerCoordinates[1]).displayGrass(); // only for testing
    }

    private void handleTeleport(ParcelView parcelView) {  // put this in the viewModel?
        this.removeFarmer();
        farmerCoordinates = parcelView.getCoordinates();//new farmerCoordinates
        this.putFarmer();
        requestFocus();
    }

    public void setOnkeyPressed(){
        //gameViewModel.gameModeProperty().get() != Mode.FREE
        this.setOnKeyPressed(e -> this.onKeyPressed(e.getCode().getChar())); // to pass event to viewModel

    }

    public void onKeyPressed(String character) {  // put this in the viewModel?
        requestFocus();
        if ("Z".equalsIgnoreCase(character)) {
            if (farmerCoordinates[1] > 0) {
                this.removeFarmer();
                farmerCoordinates = new int[]{farmerCoordinates[0], farmerCoordinates[1]-1};//int[col,line]
                this.putFarmer();
            }
        } else if ("Q".equalsIgnoreCase(character)) {
            if (farmerCoordinates[0] > 0) {
                this.removeFarmer();
                farmerCoordinates = new int[]{farmerCoordinates[0]-1, farmerCoordinates[1] };
                this.putFarmer();
            }
        } else if ("S".equalsIgnoreCase(character)) {
            if (farmerCoordinates[1] <FARM_HEIGHT - 1) {//if (farmerCoordinates[1] < FARM_WIDTH - 1)
                this.removeFarmer();
                farmerCoordinates = new int[]{farmerCoordinates[0], farmerCoordinates[1]+1};
                this.putFarmer();
            }
        } else if ("D".equalsIgnoreCase(character)) {
            if (farmerCoordinates[0] < FARM_WIDTH - 1) {// if (farmerCoordinates[0] < FARM_HEIGHT - 1)
                this.removeFarmer();
                farmerCoordinates = new int[]{farmerCoordinates[0]+1, farmerCoordinates[1]};
                this.putFarmer();
            }
        }
    }
}

