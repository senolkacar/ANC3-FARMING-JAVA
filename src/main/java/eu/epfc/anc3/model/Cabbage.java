package eu.epfc.anc3.model;

class Cabbage extends Element implements VegetableState{

    private final int MAX_POINTS = 200;
    private final double STATE_1_PERCENTAGE = 0;
    private final double STATE_2_PERCENTAGE = 0;
    private final double STATE_3_PERCENTAGE = 0.75;
    private final double STATE_4_PERCENTAGE = 1;
    private final double STATE_5_PERCENTAGE = 0;

    private int state;
    private int daysSincePlanting;

    Cabbage() {
        elementType = ElementType.CABBAGE;
        this.state = 1;
        this.daysSincePlanting = 0;
    }
    @Override
    public void incrementDay() {
        daysSincePlanting++;
        if (daysSincePlanting % 3 == 0) {
            state++;
        }
    }
    @Override
    public double harvest() {
        double points = 0;
        switch (this.state) {
            case 1:
                points = MAX_POINTS * STATE_1_PERCENTAGE;
                break;
            case 2:
                points = MAX_POINTS * STATE_2_PERCENTAGE;
                break;
            case 3:
                points = MAX_POINTS * STATE_3_PERCENTAGE;
                break;
            case 4:
                points = MAX_POINTS * STATE_4_PERCENTAGE;
                break;
            case 5:
                points = MAX_POINTS * STATE_5_PERCENTAGE;
                break;
        }
        return points;
    }

    @Override
    public int getState() {
        return state;
    }
}
