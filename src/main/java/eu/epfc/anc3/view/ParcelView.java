    package eu.epfc.anc3.view;

    import eu.epfc.anc3.model.Position;
    import eu.epfc.anc3.vm.FarmerViewModel;
    import eu.epfc.anc3.vm.ParcelViewModel;
    import javafx.beans.binding.Bindings;
    import javafx.beans.binding.DoubleBinding;
    import javafx.beans.property.ObjectProperty;
    import javafx.event.EventHandler;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.input.KeyCode;
    import javafx.scene.input.KeyEvent;
    import javafx.scene.layout.StackPane;

    import static eu.epfc.anc3.view.GameView.FARM_HEIGHT;
    import static eu.epfc.anc3.view.GameView.FARM_WIDTH;

    public class ParcelView extends StackPane {
        private static final Image dirtImage = new Image("dirt.png");
        private static final Image farmerImage = new Image("farmer.png");
        private final ImageView imageView = new ImageView(dirtImage);
        private final ImageView farmerView = new ImageView(farmerImage);
        public ParcelView(ParcelViewModel parcelViewModel,FarmerViewModel farmerViewModel,DoubleBinding parcelWidthProperty) {
            this.requestFocus();
            farmerView.xProperty().bind(Bindings.multiply(farmerViewModel.getPosition().xProperty(), widthProperty()));
            farmerView.yProperty().bind(Bindings.multiply(farmerViewModel.getPosition().yProperty(), heightProperty()));
            StackPane pane = new StackPane(imageView, farmerView);
            getChildren().add(pane);
            imageView.fitWidthProperty().bind(pane.widthProperty());
            imageView.fitHeightProperty().bind(pane.heightProperty());



            setOnMouseClicked(event -> {
                farmerViewModel.setPosition(parcelViewModel.getPosition());
                requestFocus();
            });
            this.setOnKeyPressed(event -> {
                KeyCode code = event.getCode();
                int x = farmerViewModel.getPosition().getX();
                int y = farmerViewModel.getPosition().getY();
                switch (code) {
                    case A:
                        x--;
                        break;
                    case D:
                        x++;
                        break;
                    case W:
                        y--;
                        break;
                    case S:
                        y++;
                        break;
                    default:
                        break;
                }
                x = Math.max(0, Math.min(x, FARM_WIDTH - 1));
                y = Math.max(0, Math.min(y, FARM_HEIGHT - 1));
                farmerViewModel.setPosition((new Position(x, y)));
                requestFocus();
            });

            farmerView.visibleProperty().bind(Bindings.createBooleanBinding(() ->
                            (parcelViewModel.getPosition().getX()==(farmerViewModel.getPosition().getX()))&&(parcelViewModel.getPosition().getY()==(farmerViewModel.getPosition().getY())),
                    parcelViewModel.positionProperty(), farmerViewModel.positionProperty()));
        }
    }
