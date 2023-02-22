package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.CountViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CountView extends HBox {
    private final CountViewModel countVM;
    private final Label parcelCountLabel;
    private final TextField parcelCountInput;

    public CountView(CountViewModel countVM) {
        this.countVM = countVM;

        parcelCountLabel = new Label("Nombre de parcelles: ");
        parcelCountInput = new TextField("0");
        parcelCountInput.setDisable(true);

        getChildren().addAll(parcelCountLabel, parcelCountInput);

        ReadOnlyIntegerProperty valueProperty = countVM.valueProperty();

        valueProperty.addListener((obs, old, newVal) -> parcelCountInput.setText("" + newVal));
    }
}
