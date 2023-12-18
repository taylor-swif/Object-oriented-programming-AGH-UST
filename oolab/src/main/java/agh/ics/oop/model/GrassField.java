package agh.ics.oop.model;

public class GrassField extends AbstractWorldMap {

    final int maxWidth;
    final int maxHeight;

    public GrassField(int grassCount, int id) {
        super(id);
        eventManager("drawer");
        this.maxWidth = (int) Math.sqrt(grassCount*10);
        this.maxHeight = (int) Math.sqrt(grassCount*10);
        this.bounds = new Boundary(new Vector2d(0, 0), new Vector2d(maxWidth, maxHeight));
        generateGrass(grassCount);
    }

    private void generateGrass(int grassCount) {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, grassCount);

        for(Vector2d grassPosition : randomPositionGenerator) {
            Grass grass = new Grass(grassPosition);
            placeGrass(grass);
        }
    }

    public void placeGrass(Grass grass) {
        if (canMoveTo(grass.getPosition())) {
            grasses.put(grass.getPosition(), grass);
            notify("drawer", "grass placed to position " + grass.getPosition());
        }
    }
    public boolean canMoveTo(Vector2d position) {
        return position.follows(bounds.lowerLeft()) && !isOccupiedByAnimal(position);
    }
}
