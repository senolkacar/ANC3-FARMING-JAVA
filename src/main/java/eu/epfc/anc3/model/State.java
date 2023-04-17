package eu.epfc.anc3.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public interface State {
    int CABBAGE_STATE1_DURATION = 5;
    int CABBAGE_STATE2_DURATION = 4;
    int CABBAGE_STATE3_DURATION = 3;
    int CABBAGE_STATE4_DURATION = 2;
    int CABBAGE_ROTTEN_DURATION = 10;

    double CABBAGE_STATE1_POINT_PERCENTAGE = 0;
    double CABBAGE_STATE2_POINT_PERCENTAGE = 0;
    double CABBAGE_STATE3_POINT_PERCENTAGE = 0.75;
    double CABBAGE_STATE4_POINT_PERCENTAGE = 1;

    int CARROT_STATE1_DURATION = 3;
    int CARROT_STATE2_DURATION = 3;
    int CARROT_STATE3_DURATION = 3;
    int CARROT_STATE4_DURATION = 3;
    int CARROT_ROTTEN_DURATION = 10;

    double CARROT_STATE1_POINT_PERCENTAGE = 0.1;
    double CARROT_STATE2_POINT_PERCENTAGE = 0.2;
    double CARROT_STATE3_POINT_PERCENTAGE = 0.5;
    double CARROT_STATE4_POINT_PERCENTAGE = 1;

    int MAX_POINTS_CARROT = 100;
    int MAX_POINTS_CABBAGE = 200;

    ObjectProperty<StateType> getStateType();
    void setStateType(StateType stateType);
    void incrementDay();
    void fertilize();
    void setHarvestScore();
    IntegerProperty getHarvestScore();
    int getDaysInCurrentState();
    void setDaysInCurrentState(int daysInCurrentState);
    Element getElement();
    void setElement(Element element);

}
