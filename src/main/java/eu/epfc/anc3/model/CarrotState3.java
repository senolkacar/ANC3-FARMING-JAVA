package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class CarrotState3 extends CarrotState{

    CarrotState3(Carrot carrot) {
        super(carrot);
        setStateType(StateType.STATE3);
    }

    @Override
    public void incrementDay() {
        if (getDaysInCurrentState() == CARROT_STATE3_DURATION + 1) {
            carrot.setElementState(new CarrotState4(carrot));
            setDaysInCurrentState(1);
            setStateType(StateType.STATE4);
        }
    }

    @Override
    public void setHarvestScore() {
        harvestScore.set((int)(carrot.getMAX_POINTS()*CARROT_STATE3_POINT_PERCENTAGE));
    }

    @Override
    public String toString() {
        return "CarrotState3{" +
                "carrot=" + carrot +"stateDays=" + getDaysInCurrentState()+
                '}';
    }

//    @Override
//    public ObjectProperty<StateType> getStateType() {
//        return getStateType();
//    }

    @Override
    public void fertilize() {

    }
}
