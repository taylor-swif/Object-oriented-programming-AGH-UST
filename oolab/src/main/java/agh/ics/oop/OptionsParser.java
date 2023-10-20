package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        MoveDirection[] moves = new MoveDirection[args.length];
        MoveDirection move;
        int cnt = 0;

        for (String arg : args) {
            move = switch (arg) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> null;
            };

            if (move != null) {
                moves[cnt] = move;
                cnt++;
            }

        }
        return Arrays.copyOfRange(moves, 0, cnt);
    }
}
