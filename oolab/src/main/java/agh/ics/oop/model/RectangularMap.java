package agh.ics.oop.model;


public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height, int id) {
        super(id);
        eventManager("drawer");
        bounds = new Boundary(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(bounds.lowerLeft()) && position.precedes(bounds.upperRight()) && isOccupiedByAnimal(position);
    }
}
