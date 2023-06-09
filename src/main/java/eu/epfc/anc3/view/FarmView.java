package eu.epfc.anc3.view;


import eu.epfc.anc3.model.Position;
import eu.epfc.anc3.vm.FarmViewModel;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import static eu.epfc.anc3.view.GameView.*;

public class FarmView extends GridPane {
    private final FarmViewModel farmVM;

    public FarmView(FarmViewModel farmViewModel) {
        setPadding(new Insets(PADDING));
        this.farmVM = farmViewModel;

        for (int i = 0; i < FARM_WIDTH; ++i) {
            for (int j = 0; j < FARM_HEIGHT; ++j) {
                ParcelView parcelView = new ParcelView(farmVM.getParcelViewModel(new Position(i, j)));
                add(parcelView, i, j);
            }
        }
    }
}

