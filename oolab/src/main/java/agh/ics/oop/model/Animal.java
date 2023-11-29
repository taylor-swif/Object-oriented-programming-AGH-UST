package agh.ics.oop.model;

public class Animal extends AbstractWorldElement {
    private MapDirection orientation;

    boolean movable = true;

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Animal(Vector2d newPosition) {
        super(newPosition);
        this.orientation = MapDirection.NORTH;

    }

    @Override
    public String toString() {
        return orientation.toString();
    }

    public void move(MoveDirection direction, MoveValidator validator) {

        switch (direction) {
            case RIGHT -> {
                orientation = orientation.next();
                return;
            }
            case LEFT -> {
                orientation = orientation.previous();
                return;
            }

        }

        Vector2d newPosition = this.getPosition();
        switch (direction) {
            case FORWARD -> newPosition = position.add(orientation.toUnitVector());
            case BACKWARD -> newPosition = position.subtract(orientation.toUnitVector());
        }

        if(validator.canMoveTo(newPosition)){
           position = newPosition;
        }
    }
}
