package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    public void testSimulationWithValidData1(){
        WorldMap<Animal, Vector2d> worldMap = new RectangularMap(4, 4);
        List<Vector2d> initialPositions = List.of(new Vector2d(2, 2), new Vector2d(2, 3));
        List<MoveDirection> moves = List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.FORWARD);

        Simulation simulation = new Simulation(initialPositions, moves, worldMap);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertEquals(2, animals.size());

        assertEquals("(2,1)", animals.get(0).getPosition().toString());
        assertEquals("N", animals.get(0).getOrientation().toString());

        assertEquals("(3,3)", animals.get(1).getPosition().toString());
        assertEquals("E", animals.get(1).getOrientation().toString());
    }

    @Test
    public void testSimulationWithInvalidData(){
        WorldMap<Animal, Vector2d> worldMap = new RectangularMap(4, 4);
        List<Vector2d> initialPositions = List.of(new Vector2d(2, 2), new Vector2d(2, 2));
        List<MoveDirection> moves = List.of(MoveDirection.RIGHT, MoveDirection.LEFT);

        Simulation simulation = new Simulation(initialPositions, moves, worldMap);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertEquals(1, animals.size());

        assertEquals("(2,2)", animals.get(0).getPosition().toString());
        assertEquals("N", animals.get(0).getOrientation().toString());
    }
}