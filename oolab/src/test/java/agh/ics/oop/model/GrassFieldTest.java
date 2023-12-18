package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    public void placeSunnyTest() throws PositionAlreadyOccupiedException {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(2, 4));
        Animal animal3 = new Animal(new Vector2d(10, 41));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        assertEquals(3, map.animals.size());
    }

    @Test
    public void placeCloudyTest() throws PositionAlreadyOccupiedException {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(4, 4));
        Animal animal2 = new Animal(new Vector2d(2, 4));
        Animal animal3 = new Animal(new Vector2d(4, 4));
        map.place(animal1);
        map.place(animal2);
        assertThrows(PositionAlreadyOccupiedException.class, ()->map.place(animal3));
    }

    @Test
    public void isOccupiedTest() throws PositionAlreadyOccupiedException {
        GrassField map = new GrassField(0);
        Animal animal = new Animal(new Vector2d(4, 4));
        map.place(animal);

        assertTrue(map.isOccupied(animal.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void canMoveToTest() throws PositionAlreadyOccupiedException {
        GrassField map = new GrassField(10);
        Animal animal = new Animal(new Vector2d(4, 4));
        map.place(animal);

        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(21, 37)));
        assertFalse(map.canMoveTo(new Vector2d(4, 4)));
    }

    @Test
    public void objectAtTest() throws PositionAlreadyOccupiedException {
        GrassField map = new GrassField(0);
        Animal animal = new Animal(new Vector2d(4, 4));
        map.place(animal);

        assertEquals(animal, map.objectAt(animal.getPosition()));
        assertNull(map.objectAt(new Vector2d(2, 2)));
    }
}

