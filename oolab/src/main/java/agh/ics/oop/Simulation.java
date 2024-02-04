package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable{

    final private WorldMap worldMap;
    final private List<Animal> animals;
    final public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }
    final private List<MoveDirection> moves;


    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves, WorldMap worldMap) {
        this.moves = moves;
        this.animals = new ArrayList<>();
        this.worldMap = worldMap;

        for (Vector2d initialPosition : initialPositions) {
            Animal animal = new Animal(initialPosition);
            try {
                worldMap.place(animal);
                animals.add(animal);

            } catch (PositionAlreadyOccupiedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run() {
        int numberOfAnimals = animals.size();
        int currentAnimalIndex = 0;
        

        for (MoveDirection move : moves) {
            Animal currentAnimal = animals.get(currentAnimalIndex);
            worldMap.move(currentAnimal, move);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException();
            }

            currentAnimalIndex = (currentAnimalIndex + 1) % numberOfAnimals;
        }
    }
}
