package eu.epfc.anc3.model;

import eu.epfc.anc3.view.ParcelView;
import javafx.beans.property.ReadOnlyObjectProperty;

public class Farm {
    static final int FARM_WIDTH = 25;
    static final int FARM_HEIGHT = 15;

    private final Parcel[][] matrix;

    Farm(){
        matrix = new Parcel[FARM_HEIGHT][];
        for(int i = 0; i < FARM_HEIGHT; ++i){
            matrix[i] = new Parcel[FARM_WIDTH];
            for(int j=0; j<FARM_WIDTH;++j){
                matrix[i][j] = new Parcel();
            }
        }
    }

    ReadOnlyObjectProperty<ParcelValue> valueProperty(int line, int col) {
        return matrix[line][col].valueProperty();
    }

    ParcelValue getValue(int line, int col) {
        return matrix[line][col].getValue();
    }

    public boolean teleportFarmer(int line, int col, ParcelValue currentParcelValue) {
        return matrix[line][col].setValue(currentParcelValue);//?
    }




}
