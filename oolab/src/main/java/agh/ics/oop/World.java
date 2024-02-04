package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");

        WorldMap worldMap = new RectangularMap(4, 4, 1);

        MapChangeListener drawer = new ConsoleMapDisplay();

        worldMap.subscribe("drawer", drawer);

//        List<MoveDirection> directions = OptionsParser.parse(args);
        List<MoveDirection> directions = List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        Simulation simulation = new Simulation(positions, directions, worldMap);
        simulation.run();

        System.out.println("Stop");
    }

}
