package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private WorldMap<Animal, Vector2d> worldMap;
    private List<Animal> animals;
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }
    private List<MoveDirection> moves;


    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves, WorldMap<Animal, Vector2d> worldMap) {
        this.moves = moves;
        this.animals = new ArrayList<>();
        this.worldMap = worldMap;

        for (Vector2d initialPosition : initialPositions) {
            Animal animal = new Animal(initialPosition);
            if (worldMap.place(animal)) {
                animals.add(animal);
            }
        }
    }

    public void run() {
        int numberOfAnimals = animals.size();
        int currentAnimalIndex = 0;

        System.out.println(worldMap);

        for (MoveDirection move : moves) {
            Animal currentAnimal = animals.get(currentAnimalIndex);
            worldMap.move(currentAnimal, move);

            System.out.println(worldMap);

            currentAnimalIndex = (currentAnimalIndex + 1) % numberOfAnimals;
        }
    }

}
