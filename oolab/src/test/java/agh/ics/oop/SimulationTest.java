package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    public void testSimulationWithValidData() {
        List<Vector2d> initialPositions = List.of(new Vector2d(2, 2), new Vector2d(2, 3));
        List<MoveDirection> moves = List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT);

        Simulation simulation = new Simulation(initialPositions, moves);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertEquals(2, animals.size());

        assertEquals("Position: (2,2), Orientation: Północ", animals.get(0).toString());
        assertEquals("Position: (2,3), Orientation: Północ", animals.get(1).toString());
    }

    @Test
    public void testSimulationWithInvalidData() {
        List<Vector2d> initialPositions = List.of(new Vector2d(2, 2), new Vector2d(2, 2));
        List<MoveDirection> moves = List.of(MoveDirection.RIGHT, MoveDirection.LEFT);

        Simulation simulation = new Simulation(initialPositions, moves);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertEquals(2, animals.size());

        assertEquals("Position: (2,2), Orientation: Wschód", animals.get(0).toString());
        assertEquals("Position: (2,2), Orientation: Zachód", animals.get(1).toString());
    }

}