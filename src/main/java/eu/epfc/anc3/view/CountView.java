package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.CountViewModel;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CountView extends HBox {
    private final Label countLabel = new Label("Count: ");
    private final TextField countTextField = new TextField();

    private final CountViewModel countViewModel;

    public CountView(CountViewModel countViewModel){
        this.countViewModel = countViewModel;
        getChildren().addAll(countLabel, countTextField);
    }

}
