    package eu.epfc.anc3.view;

    import eu.epfc.anc3.model.Position;
    import eu.epfc.anc3.vm.FarmViewModel;
    import eu.epfc.anc3.vm.FarmerViewModel;
    import javafx.beans.binding.DoubleBinding;
    import javafx.beans.property.DoubleProperty;
    import javafx.geometry.Insets;
    import javafx.scene.layout.ColumnConstraints;
    import javafx.scene.layout.GridPane;
    import javafx.scene.layout.RowConstraints;

    import static eu.epfc.anc3.view.GameView.*;


    public class FarmView extends GridPane {
        private final FarmerViewModel farmerViewModel;

        public FarmView(FarmViewModel farmViewModel, FarmerViewModel farmerViewModel, DoubleProperty farmWidthProperty) {
            this.farmerViewModel = farmerViewModel;
            setPadding(new Insets(PADDING));
            DoubleBinding parcelWidthProperty = farmWidthProperty.subtract(PADDING * 2).divide(FARM_WIDTH);

            for (int i = 0; i < FARM_WIDTH; i++) {
                ColumnConstraints columnConstraints = new ColumnConstraints();
                columnConstraints.setPercentWidth(100.0 / FARM_WIDTH);
                getColumnConstraints().add(columnConstraints);
            }

            for(int i = 0; i < FARM_HEIGHT; i++) {
                RowConstraints rowConstraints = new RowConstraints();
                rowConstraints.setPercentHeight(100.0 / FARM_HEIGHT);
                getRowConstraints().add(rowConstraints);
            }

            for(int i = 0; i < FARM_WIDTH; i++) {
                for(int j = 0; j < FARM_HEIGHT; j++) {
                    ParcelView parcelView = new ParcelView(farmViewModel.getParcelViewModel(new Position(i,j)), farmerViewModel, parcelWidthProperty);
                    add(parcelView, i, j);
                }
            }
        }
    }
