package eu.epfc.anc3.model;

import java.util.List;

class Farmer extends Element {
    private Position position;

    Farmer() {
        elementType = ElementType.FARMER;
    }

    Position getPosition() {
        return position;
    }

    void setPosition(Position position) {
        this.position = position;
    }

    void teleport(Position position, Farm farm) {
        farm.removeElement(getPosition(), ElementType.FARMER);
        setPosition(position);
        farm.addElement(position, this);
//        List<Element> elements = farm.getValue(position);
//        for (Element e : elements) {
//            System.out.println(e.getState());
//        }
    }

    void moveUp(Farm farm) {
        if (getPosition().getY() > 0) {
            farm.removeElement(getPosition(), ElementType.FARMER);
            setPosition(new Position(getPosition().getX(), getPosition().getY() - 1));
            farm.addElement(getPosition(), this);
        }
    }

    void moveLeft(Farm farm) {
        if (getPosition().getX() > 0) {
            farm.removeElement(getPosition(), ElementType.FARMER);
            setPosition(new Position(getPosition().getX() - 1, getPosition().getY()));
            farm.addElement(getPosition(), this);
        }
    }

    void moveRight(Farm farm) {
        if (getPosition().getX() < Farm.FARM_WIDTH - 1) {
            farm.removeElement(getPosition(), ElementType.FARMER);
            setPosition(new Position(getPosition().getX() + 1, getPosition().getY()));
            farm.addElement(getPosition(), this);
        }
    }

    void moveDown(Farm farm) {
        if (getPosition().getY() < Farm.FARM_HEIGHT - 1) {
            farm.removeElement(getPosition(), ElementType.FARMER);
            setPosition(new Position(getPosition().getX(), getPosition().getY() + 1));
            farm.addElement(getPosition(), this);
        }
    }

    @Override
    public Element getCopy() {
        return this;
    }

    public Farmer(Farmer farmer) {
        this.position = new Position(farmer.position.getX(), farmer.position.getY());
    }


}
