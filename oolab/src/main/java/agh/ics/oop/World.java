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
            switch (move) {
                case FORWARD ->  System.out.println("Do przodu");
                case BACKWARD ->  System.out.println("Do tyłu");
                case RIGHT ->  System.out.println("Zwierzak skręca w prawo");
                case LEFT ->  System.out.println("Zwierzak skręca w lewo");
                default -> System.out.print("");
            }
        }
    }
}
