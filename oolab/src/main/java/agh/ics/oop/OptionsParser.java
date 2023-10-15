package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        MoveDirection[] moves = new MoveDirection[args.length];

        for (int i = 0; i < args.length; i++){
            MoveDirection move = switch (args[i]){
                case "f" ->  MoveDirection.FORWARD;
                case "b" ->  MoveDirection.BACKWARD;
                case "r" ->  MoveDirection.RIGHT;
                case "l" ->  MoveDirection.LEFT;
                default -> null;
            };
            moves[i] = move;
        }
        return moves;
    }
}
