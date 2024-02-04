package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    public void testParseValidInputs() {
        String[] args = {"f", "b", "r", "l", "f"};
        List<MoveDirection> expected = Arrays.asList(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD
        );

        List<MoveDirection> result = OptionsParser.parse(args);

        assertEquals(expected, result);
    }

    @Test
    public void testParseInvalidInputs() {
        String[] args = {"f", "x", "b", "invalid", "r", "l"};
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args));

    }

    @Test
    public void testParseEmptyInputs() {
        String[] args = {};
        List<MoveDirection> expected = new ArrayList<>();

        List<MoveDirection> result = OptionsParser.parse(args);

        assertEquals(expected, result);
    }

}