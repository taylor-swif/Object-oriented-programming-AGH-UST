package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;


public class RectangularMap extends AbstractWorldMap {
    private final Vector2d upperRight;

    public RectangularMap(int width, int height) {
        upperRight = new Vector2d(width, height);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !isOccupiedByAnimal(position);
    }
}
