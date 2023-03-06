package eu.epfc.anc3.model;

class Cabbage extends Element{

    private CabbageState cabbageState;

    Cabbage() {
        elementType = ElementType.CABBAGE;
        cabbageState = new CabbageState1();
    }

    CabbageState getCabbageState() {
        return cabbageState;
    }

    void setCabbageState(CabbageState cabbageState) {
        this.cabbageState = cabbageState;
    }
}
