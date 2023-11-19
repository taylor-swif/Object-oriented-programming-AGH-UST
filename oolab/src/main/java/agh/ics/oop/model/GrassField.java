package agh.ics.oop.model;


import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public class GrassField extends AbstractWorldMap {

    final int maxWidth;
    final int maxHeight;

    public GrassField(int grassCount) {
        this.maxWidth = (int) Math.sqrt(grassCount*10);
        this.maxHeight = (int) Math.sqrt(grassCount*10);
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
        }
    }
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && !isOccupiedByAnimal(position);
    }
}
