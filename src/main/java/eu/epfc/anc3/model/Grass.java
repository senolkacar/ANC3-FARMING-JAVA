package eu.epfc.anc3.model;

import javafx.scene.image.Image;

public class Grass extends Elements{
    private static final Image grassImage = new Image("grass.png");

    public Grass() {
        super(Type.GRASS);
        setImage(grassImage);
    }
}
