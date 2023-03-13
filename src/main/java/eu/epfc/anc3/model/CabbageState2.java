package eu.epfc.anc3.model;

class CabbageState2 extends CabbageState{

    String image = "cabbage3.png";

    public CabbageState2(Cabbage cabbage) {
        super(cabbage);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE2_DURATION
                || (!cabbage.hasGrass() && cabbage.getDaysInCurrentState() == CABBAGE_STATE2_DURATION + 1)){
            cabbage.setCabbageState(new CabbageState3(cabbage));
            cabbage.setDaysInCurrentState(1);
            cabbage.setImage(image);
            cabbage.setImageTypeObjectProperty(ImageType.CABBAGE_STATE3_IMAGE);
        }
    }

    @Override
    public void setHarvestScore() {
        cabbage.setHarvestScore((int)(cabbage.getMAX_POINTS()*CABBAGE_STATE2_POINT_PERCENTAGE));
    }


}
