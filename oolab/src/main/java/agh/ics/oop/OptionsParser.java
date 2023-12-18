package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> moves = new ArrayList<>();
        for (String arg : args) {
            MoveDirection move = switch (arg) {
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(arg + " is not legal move specification.");
            };

            moves.add(move);
        }
        return new ArrayList<>(moves);
    }
}
