package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    public void testParseValidInputs() {
        String[] args = {"f", "b", "r", "l", "f"};
        MoveDirection[] expected = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD
        };

        MoveDirection[] result = OptionsParser.parse(args);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testParseInvalidInputs() {
        String[] args = {"f", "x", "b", "invalid", "r", "l"};
        MoveDirection[] expected = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        };

        MoveDirection[] result = OptionsParser.parse(args);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testParseEmptyInputs() {
        String[] args = {};
        MoveDirection[] expected = {};

        MoveDirection[] result = OptionsParser.parse(args);

        assertArrayEquals(expected, result);
    }

}