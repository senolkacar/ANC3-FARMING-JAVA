package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.FarmViewModel;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static eu.epfc.anc3.view.GameView.FARM_HEIGHT;//
import static eu.epfc.anc3.view.GameView.FARM_WIDTH;
import static eu.epfc.anc3.view.GameView.PADDING;

public class FarmView extends GridPane {
    private static final Image farmerImage = new Image("farmer.png");//


    public FarmView(FarmViewModel farmViewModel, DoubleProperty farmWidthProperty, DoubleProperty farmHeightProperty) {
        //setPadding(new Insets(20,20,20,20));
        setHgap(0);
        setVgap(0);
        setGridLinesVisible(true);
        //setPadding(Insets.EMPTY);

        setPadding(new Insets(PADDING));
        DoubleBinding parcelWidthProperty = farmWidthProperty.subtract(PADDING * 2).divide(FARM_WIDTH);

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

        for (int i = 0; i < FARM_HEIGHT; ++i) {
            for (int j = 0; j < FARM_WIDTH; ++j) {
                ParcelView parcelView = new ParcelView(farmViewModel.getParcelViewModel(i, j));
                //ParcelView parcelView = new ParcelView();//for test
                parcelView.setPadding(Insets.EMPTY);
                add(parcelView, j, i);// lignes/colonnes inversées dans gridpane
            }
        }

        ParcelView parcelView = new ParcelView(farmerImage);
        add(parcelView,0,0);

    }
}

