package eu.epfc.anc3.model;

public class Memento {
    private final Farm farm;
    private final Farmer farmer;
    private final Day day;
    private final boolean farmerMovementEnable;
    private final int scoreProperty;
    private final Mode gameMode;

    public Memento(Farm farm, Farmer farmer, Day day, boolean farmerMovementEnable, int scoreProperty, Mode gameMode) {
        this.farm = farm;
        this.farmer = farmer;
        this.day = day;
        this.farmerMovementEnable = farmerMovementEnable;
        this.scoreProperty = scoreProperty;
        this.gameMode = gameMode;
    }

    public Farm getFarm() {
        return farm;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public Day getDay() {
        return day;
    }

    public boolean getFarmerMovementEnable() {
        return farmerMovementEnable;
    }

    public int getScoreProperty() {
        return scoreProperty;
    }

    public Mode getGameMode() {
        return gameMode;
    }
}

