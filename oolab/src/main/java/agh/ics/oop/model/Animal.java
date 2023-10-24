package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private final Vector2d lowerLeft = new Vector2d(0, 0);
    private final Vector2d upperRight = new Vector2d(4, 4);

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
        return "Position: " + position + ", Orientation: " + orientation;
    }

    boolean isAt(Vector2d position) {
        return this.position.equals((position));
    }

    public void move(MoveDirection direction) {
        Vector2d newPosition = this.position;

        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> this.position = this.position.add(orientation.toUnitVector());
            case BACKWARD -> this.position = this.position.subtract(orientation.toUnitVector());
        }

        if (newPosition.follows(lowerLeft) && newPosition.precedes(upperRight)) {
            this.position = newPosition;
        }
    }
}
