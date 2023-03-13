package eu.epfc.anc3.model;

import javafx.scene.image.ImageView;

abstract class CarrotState implements State {
    public static int CARROT_STATE1_DURATION = 3;
    public static int CARROT_STATE2_DURATION = 3;
    public static int CARROT_STATE3_DURATION = 3;
    public static int CARROT_STATE4_DURATION = 3;
    public static int CARROT_ROTTEN_DURATION = 10;

    public static double CARROT_STATE1_POINT_PERCENTAGE = 0.1;
    public static double CARROT_STATE2_POINT_PERCENTAGE = 0.2;
    public static double CARROT_STATE3_POINT_PERCENTAGE = 0.5;
    public static double CARROT_STATE4_POINT_PERCENTAGE = 1;

    protected Carrot carrot;


    public CarrotState (Carrot carrot) {
        this.carrot = carrot;

    }

    public abstract void incrementDay();

    public abstract void setHarvestScore();

    public void fertilize(){
    }

    @Override
    public String toString() {
        return "CarrotState{" +
                "carrot=" + carrot +
                '}';
    }


}
