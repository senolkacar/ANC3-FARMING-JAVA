package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Farm;
import eu.epfc.anc3.model.Position;
import eu.epfc.anc3.vm.FarmViewModel;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static eu.epfc.anc3.model.Farm.PADDING;


public class FarmView extends GridPane {
    private final FarmViewModel farmVM;

    public FarmView(FarmViewModel farmViewModel) {
        setPadding(new Insets(PADDING));
        this.farmVM = farmViewModel;
        super.setGridLinesVisible(true);

        for (int i = 0; i < Farm.FARM_WIDTH; ++i) {//line
            for (int j = 0; j < Farm.FARM_HEIGHT; ++j) {//col
                ParcelView parcelView = new ParcelView(farmVM.getParcelViewModel(new Position(i,j)));//line,col
                add(parcelView, i, j);//inverser ?
            }
        }
    }
}

