package agh.ics.oop.model;

public class Grass extends AbstractWorldElement {
    public Grass(Vector2d position) {
        super(position);
    }
    boolean movable = false;

    @Override
    public String toString() {
        return "*";
    }
}

