package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Farm;
import eu.epfc.anc3.vm.FarmViewModel;
import javafx.scene.layout.GridPane;


public class FarmView extends GridPane {
    private final FarmViewModel farmVM;

    public FarmView(FarmViewModel farmViewModel) {
        this.farmVM = farmViewModel;
        super.setGridLinesVisible(true);

        for (int i = 0; i < Farm.FARM_HEIGHT; ++i) {//line
            for (int j = 0; j < Farm.FARM_WIDTH; ++j) {//col
                ParcelView parcelView = new ParcelView(farmVM.getParcelViewModel(new int[]{i, j}));//line,col
                super.add(parcelView, i, j);//inverser ?
            }
        }
    }
}

