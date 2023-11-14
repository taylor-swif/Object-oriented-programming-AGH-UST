package agh.ics.oop.model;


import java.util.*;

public class GrassField extends AbstractWorldMap {

    public GrassField(int grassCount) {
        generateGrass(grassCount);
    }

    private void generateGrass(int grassCount) {

        Random rand = new Random();
        int grassGenerated = 0;

        while (grassGenerated < grassCount){
            int x = rand.nextInt((int) Math.sqrt(grassCount*10));
            int y = rand.nextInt((int) Math.sqrt(grassCount*10));

            Vector2d grassPosition = new Vector2d(x, y);
            Grass grass = new Grass(grassPosition);

            if (placeGrass(grass)){
                grassGenerated += 1;
            }
        }
    }

    public boolean placeGrass(Grass grass) {
        if (canMoveTo(grass.getPosition())) {
            grasses.put(grass.getPosition(), grass);
            return true;
        }
        return false;
    }
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && !isOccupiedByAnimal(position);
    }
}
