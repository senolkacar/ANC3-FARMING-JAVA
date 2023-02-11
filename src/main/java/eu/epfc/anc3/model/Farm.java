package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;

import java.time.Period;

public class Farm {
        static final int FARM_WIDTH = 25;
        static final int FARM_HEIGHT = 15;

        private final Parcel[][] matrix;


        Farm(){
            matrix = new Parcel[FARM_HEIGHT][FARM_WIDTH];
            for(int i = 0; i < FARM_HEIGHT; i++) {
                matrix[i] = new Parcel[FARM_WIDTH];
                for(int j = 0; j < FARM_WIDTH; j++) {
                    matrix[i][j] = new Parcel();
                }
            }
        }

    ReadOnlyObjectProperty<Type> valueProperty(int line, int col) {
        return matrix[line][col].valueProperty();
    }

    Type getValue(int line, int col) {
        return matrix[line][col].getValue();
    }

    public ObjectProperty<Type> getParcelAt(int x, int y) {
        return matrix[x][y].valueProperty();
    }




}
