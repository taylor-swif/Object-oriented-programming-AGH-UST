package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;


    public void setPosition(Vector2d position) {
        this.position = position;
    }

    private Vector2d position;

    public MapDirection getOrientation() {
        return orientation;
    }
    public Vector2d getPosition() {
        return position;
    }

    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(Vector2d newPosition) {
        this.orientation = MapDirection.NORTH;
        this.position = newPosition;
    }

    @Override
    public String toString() {
        return orientation.toString();
    }

    boolean isAt(Vector2d position) {
        return this.position.equals((position));
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
