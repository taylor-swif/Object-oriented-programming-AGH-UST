package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class RandomPositionGenerator implements Iterable<Vector2d> {
    final int maxWidth;
    final int maxHeight;
    final int grassCount;

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassCount = grassCount;
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new Iterator<>() {
            private final List<Vector2d> positions = generateRandomPositions();

            private List<Vector2d> generateRandomPositions() {
                List<Vector2d> allPositions = new ArrayList<>();
                for (int x = 0; x < maxWidth; x++) {
                    for (int y = 0; y < maxHeight; y++) {
                        allPositions.add(new Vector2d(x, y));
                    }
                }

                Collections.shuffle(allPositions);
                return allPositions.subList(0, grassCount);
            }

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < grassCount;
            }

            @Override
            public Vector2d next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more positions to generate.");
                }
                return positions.get(currentIndex++);
            }
        };
    }
}

