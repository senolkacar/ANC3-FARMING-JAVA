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

    private final Label dayCountLabel;
    private final TextField dayCountInput;

    public CountView(CountViewModel countVM) {
        this.countVM = countVM;
        ReadOnlyIntegerProperty valueProperty = countVM.valueProperty();

        ReadOnlyIntegerProperty dayInputProperty = countVM.dayProperty();

        parcelCountLabel = new Label("Nombre de parcelles: ");
        parcelCountInput = new TextField("0");
        parcelCountInput.setDisable(true);//binding

        dayCountLabel = new Label("Jour: ");
        dayCountInput = new TextField("1");
        dayCountInput.setDisable(true);//binding

        getChildren().addAll(parcelCountLabel, parcelCountInput,dayCountLabel,dayCountInput);

        valueProperty.addListener((obs, old, newVal) -> parcelCountInput.setText("" + newVal));

        dayInputProperty.addListener((obs, old, newVal) -> dayCountInput.setText("" + newVal));
    }
}
