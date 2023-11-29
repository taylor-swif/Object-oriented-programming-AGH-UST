package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");

        WorldMap<Animal, Vector2d> worldMap = new RectangularMap(4, 4);

        MapChangeListener drawer = new ConsoleMapDisplay();

        worldMap.subscribe("move", drawer);

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        Simulation simulation = new Simulation(positions, directions, worldMap);
        simulation.run();

        System.out.println("Stop");
    }
    public static void run(List<MoveDirection> args) {

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
