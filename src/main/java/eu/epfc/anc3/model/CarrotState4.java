package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.scene.image.ImageView;

class CarrotState4 extends CarrotState{

    CarrotState4(Carrot carrot) {
        super(carrot);
        setStateType(StateType.STATE4);
    }

    @Override
    public void incrementDay() {
        if (getDaysInCurrentState() == CARROT_STATE4_DURATION + 1) {
            carrot.setElementState(new CarrotRotten(carrot));
            setDaysInCurrentState(1);
            setStateType(StateType.STATEROTTEN);
        }
    }

    @Override
    public void setHarvestScore() {
       harvestScore.set((int)(carrot.getMAX_POINTS()*CARROT_STATE4_POINT_PERCENTAGE));
    }

    @Override
    public String toString() {
        return "CarrotState4{" +
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
