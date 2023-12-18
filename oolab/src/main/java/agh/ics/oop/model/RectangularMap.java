package agh.ics.oop.model;


public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        eventManager("move");
        bounds = new Boundary(new Vector2d(0, 0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(bounds.lowerLeft()) && position.precedes(bounds.upperRight()) && !isOccupiedByAnimal(position);
    }
}
