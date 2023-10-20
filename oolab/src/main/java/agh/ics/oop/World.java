package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Start");

        MoveDirection[] moves = OptionsParser.parse(args);
        run(moves);

        System.out.println("Stop");
    }
    public static void run(MoveDirection[] args) {

        for(MoveDirection move : args){
            String message = switch (move) {
                case FORWARD -> "Do przodu";
                case BACKWARD -> "Do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };

            System.out.println(message);
        }
    }
}
