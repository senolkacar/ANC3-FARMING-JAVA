package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.FarmViewModel;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.GridPane;

import static eu.epfc.anc3.view.GameView.FARM_HEIGHT;
import static eu.epfc.anc3.view.GameView.FARM_WIDTH;
import static eu.epfc.anc3.view.GameView.PADDING;

public class FarmView extends GridPane {

    public FarmView(FarmViewModel farmViewModel, DoubleProperty farmWidthProperty,DoubleProperty farmHeightProperty){
        setGridLinesVisible(true);
        DoubleBinding parcelWidthProperty = farmWidthProperty.subtract(PADDING * 2).divide(FARM_WIDTH);

        for(int i=0;i<FARM_HEIGHT;++i){
            for(int j=0;j<FARM_WIDTH;++j){
                ParcelView parcelView = new ParcelView(farmViewModel.getParcelViewModel(i,j),parcelWidthProperty);
            }
        }

    }
}
