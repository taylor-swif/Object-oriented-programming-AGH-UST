package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationApp;
import javafx.application.Application;

import java.util.List;

public class WorldGUI {
    public static void main(String[] args) {
        System.out.println("Start");

        Application.launch(SimulationApp.class, args);

        WorldMap<Animal, Vector2d> worldMap = new RectangularMap(4, 4, 1);

        MapChangeListener drawer = new ConsoleMapDisplay();

        worldMap.subscribe("drawer", drawer);

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        Simulation simulation = new Simulation(positions, directions, worldMap);
        simulation.run();

        System.out.println("Stop");
    }

}
