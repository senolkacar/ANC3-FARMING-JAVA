package eu.epfc.anc3.model;

class CabbageRotten extends CabbageState {

    String image = "0";

    public CabbageRotten(Cabbage cabbage) {
        super(cabbage);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -4
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION + 1)){
            cabbage.setImage(image);
            cabbage.setHarvestScore(-(int)(cabbage.getMAX_POINTS()));

        }
    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore(-(int)(cabbage.getMAX_POINTS()* 0.1 *cabbage.getDaysInCurrentState()));
    }

}
