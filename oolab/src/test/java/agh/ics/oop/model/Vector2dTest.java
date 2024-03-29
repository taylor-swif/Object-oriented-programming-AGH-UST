package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        assertEquals("N", MapDirection.NORTH.toString());
        assertEquals("E", MapDirection.EAST.toString());
        assertEquals("S", MapDirection.SOUTH.toString());
        assertEquals("W", MapDirection.WEST.toString());
    }

    @Test
    void opposite() {
        Vector2d vector = new Vector2d(3, 5);
        Vector2d oppositeVector = vector.opposite();
        assertEquals(-3, oppositeVector.x());
        assertEquals(-5, oppositeVector.y());
    }

    @Test
    void precedes() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(4, 5);

        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
        assertTrue(v1.precedes(v1));
    }

    @Test
    void follows() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(4, 5);

        assertTrue(v2.follows(v1));
        assertFalse(v1.follows(v2));
        assertTrue(v1.follows(v1));
    }

    @Test
    void add() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(4, 5);

        Vector2d result = v1.add(v2);

        assertEquals(6, result.x());
        assertEquals(8, result.y());
    }

    @Test
    void subtract() {
        Vector2d v1 = new Vector2d(4, 5);
        Vector2d v2 = new Vector2d(2, 3);

        Vector2d result = v1.subtract(v2);

        assertEquals(2, result.x());
        assertEquals(2, result.y());
    }

    @Test
    void upperRight() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(4, 5);

        Vector2d result = v1.upperRight(v2);

        assertEquals(4, result.x());
        assertEquals(5, result.y());
    }

    @Test
    void lowerLeft() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(4, 5);

        Vector2d result = v1.lowerLeft(v2);

        assertEquals(2, result.x());
        assertEquals(3, result.y());
    }

    @Test
    void testEquals() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(2, 3);
        Vector2d v3 = new Vector2d(4, 5);

        assertEquals(v1, v2);
        assertNotEquals(v1, v3);
    }
}