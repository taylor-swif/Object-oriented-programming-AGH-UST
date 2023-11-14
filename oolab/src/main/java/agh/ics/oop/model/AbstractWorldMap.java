package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

import agh.ics.oop.model.util.MapVisualizer;


public abstract class AbstractWorldMap implements WorldMap<Animal, Vector2d>{
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final Map<Vector2d, Grass> grasses = new HashMap<>();
    protected final Vector2d lowerLeft = new Vector2d(0, 0);
    protected final Vector2d upperRight = new Vector2d(10, 10);
    protected MapVisualizer map = new MapVisualizer(this);


    @Override
    public String toString() {
        return map.draw(lowerLeft, upperRight);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            changeMapBounds(animal.getPosition());
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return animals.get(position) != null;
    }

    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);

        if (oldPosition != animal.getPosition()){
            animals.put(animal.getPosition(), animals.remove(oldPosition));
        }

    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.get(position) != null) {
            return (WorldElement) animals.get(position);
        } else if (grasses.get(position) != null) {
            return (WorldElement) grasses.get(position);
        }
        else {
            return null;
        }
    }

    public void changeMapBounds(Vector2d elementPosition) {
        lowerLeft.lowerLeft(elementPosition);
        upperRight.upperRight(elementPosition);
    }

    @Override
    public Map<Vector2d, WorldElement> getElements() {
        Map<Vector2d, WorldElement> result = new HashMap<>(animals);
        result.putAll(grasses);
        return result;
    }
}
