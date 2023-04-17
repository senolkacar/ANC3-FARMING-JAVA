package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.CountViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CountView extends HBox {
    private final CountViewModel countVM;
    private final Label dayCountLabel;
    private final TextField dayCountInput;
    private final Label scoreLabel;
    private final TextField scoreInput;

    public CountView(CountViewModel countVM) {
        this.setPadding(new Insets(20));
        this.setSpacing(50);

        this.countVM = countVM;
        ReadOnlyIntegerProperty dayInputProperty = countVM.dayProperty();
        ReadOnlyIntegerProperty scoreProperty = countVM.scoreProperty();

        dayCountLabel = new Label("Jour: ");
        dayCountInput = new TextField("1");
        dayCountInput.setDisable(true);

        scoreLabel = new Label("Score");
        scoreInput = new TextField("0");
        scoreInput.setDisable(true);

        getChildren().addAll(scoreLabel,scoreInput,dayCountLabel,dayCountInput);

        dayInputProperty.addListener((obs, old, newVal) -> dayCountInput.setText("" + newVal));

        scoreProperty.addListener((obs, old, newVal) ->scoreInput.setText(""+newVal));
    }
}
