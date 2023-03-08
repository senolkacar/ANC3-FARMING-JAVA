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

    private final Label scoreLabel;
    private final TextField scoreInput;


    public CountView(CountViewModel countVM) {
        this.countVM = countVM;
        ReadOnlyIntegerProperty valueProperty = countVM.valueProperty();

        ReadOnlyIntegerProperty dayInputProperty = countVM.dayProperty();

        ReadOnlyIntegerProperty scoreInputProperty = countVM.scoreProperty();

        parcelCountLabel = new Label("Nombre de parcelles: ");
        parcelCountInput = new TextField("0");
        parcelCountInput.setDisable(true);//binding

        dayCountLabel = new Label("Jour: ");
        dayCountInput = new TextField("1");
        dayCountInput.setDisable(true);//binding

        scoreLabel = new Label("Score: ");
        scoreInput = new TextField("0");
        scoreInput.setDisable(true);//binding

        getChildren().addAll(parcelCountLabel, parcelCountInput,dayCountLabel,dayCountInput,scoreLabel,scoreInput);

        valueProperty.addListener((obs, old, newVal) -> parcelCountInput.setText("" + newVal));

        dayInputProperty.addListener((obs, old, newVal) -> dayCountInput.setText("" + newVal));

        scoreInputProperty.addListener((obs, old, newVal) -> scoreInput.setText("" + newVal));


    }
}
