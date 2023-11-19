package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;


public class RectangularMap implements WorldMap<Animal, Vector2d> {
    Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final Vector2d upperRight;
    private final Vector2d lowerLeft = new Vector2d(0, 0);

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        upperRight = new Vector2d(width, height);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);

        if (oldPosition != animal.getPosition()){
            animals.put(animal.getPosition(), animals.remove(oldPosition));
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }
    @Override
    public String toString() {
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !isOccupied(position);
    }
}
