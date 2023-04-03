package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;

class CabbageRotten extends CabbageState {
    CabbageRotten(Cabbage cabbage) {
        super(cabbage);
        setStateType(StateType.STATEROTTEN);
    }

    @Override
    public void incrementDay() {
        if (cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION -5
                || (!cabbage.hasGrass() && getDaysInCurrentState() == CABBAGE_ROTTEN_DURATION+1)){
//            cabbage.setImage(image);
            //cabbage disappears on 11th day in dirt, but for the formula in harvestscore
            //we need to pass the last rotten day of the cabbage which is 10th day
            if(!cabbage.hasGrass()){
                setDaysInCurrentState(getDaysInCurrentState()-1);
            }
            setHarvestScore();
            setStateType(StateType.STATE0);

        }
    }

    @Override
    public void setHarvestScore() {
        harvestScore.set(-(int)(cabbage.getMAX_POINTS()* 0.1 *getDaysInCurrentState()));
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return getStateType();
//    }

    @Override
    public void fertilize() {

    }
}
