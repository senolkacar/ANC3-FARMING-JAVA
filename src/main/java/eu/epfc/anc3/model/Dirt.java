package eu.epfc.anc3.model;

import javafx.scene.image.Image;

public class Dirt extends Elements {
    private static final Image dirtImage = new Image("dirt.png");

    public Dirt() {
        super(Type.DIRT);
        setImage(dirtImage);
    }
}
