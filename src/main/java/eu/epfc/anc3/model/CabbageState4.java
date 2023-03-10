package eu.epfc.anc3.model;

class CabbageState4 extends CabbageState {

    String image = "rotten_cabbage.png";

    public CabbageState4(Cabbage cabbage) {
        super(cabbage);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE4_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE4_DURATION + 1)){
            cabbage.setCabbageState(new CabbageRotten(cabbage));
            cabbage.setDaysInCurrentState(1);
            cabbage.setImage(image);
        }
    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE4_POINT_PERCENTAGE));
    }

}
