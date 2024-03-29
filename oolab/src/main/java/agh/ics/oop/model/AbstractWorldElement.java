package agh.ics.oop.model;

public abstract class AbstractWorldElement implements WorldElement {
    protected Vector2d position;

    public AbstractWorldElement(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

}
