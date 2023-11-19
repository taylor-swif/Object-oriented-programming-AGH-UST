package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomPositionGeneratorTest {

    @Test
    void iteratorShouldGenerateCorrectNumberOfPositions() {
        int maxWidth = 10;
        int maxHeight = 10;
        int grassCount = 5;

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, grassCount);
        int count = 0;
        for (Vector2d ignored : randomPositionGenerator) {
            count++;
        }

        assertEquals(grassCount, count);
    }

    @Test
    void iteratorShouldGenerateUniquePositions() {
        int maxWidth = 10;
        int maxHeight = 10;
        int grassCount = 5;

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, grassCount);
        Set<Vector2d> generatedPositions = new HashSet<>();
        for (Vector2d position : randomPositionGenerator) {
            assertFalse(generatedPositions.contains(position));
            generatedPositions.add(position);
        }
    }

    @Test
    void iteratorShouldGeneratePositionsInsideSpecifiedRange() {
        int maxWidth = 10;
        int maxHeight = 10;
        int grassCount = 10;

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, grassCount);
        for (Vector2d position : randomPositionGenerator) {
            assertTrue(position.getX() >= 0 && position.getX() < maxWidth);
            assertTrue(position.getY() >= 0 && position.getY() < maxHeight);
        }
    }
}