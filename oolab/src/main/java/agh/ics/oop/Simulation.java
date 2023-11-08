package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {


    private List<Animal> animals;
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }
    private List<MoveDirection> moves;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves) {
        this.moves = moves;
        this.animals = new ArrayList<>();

        for (Vector2d initialPosition : initialPositions) {
            Animal animal = new Animal(initialPosition);
            animals.add(animal);
        }
    }

    public void run() {
        int numberOfAnimals = animals.size();
        int currentAnimalIndex = 0;

        for (MoveDirection move : moves) {
            Animal currentAnimal = animals.get(currentAnimalIndex);
            currentAnimal.move(move);

            System.out.println("Zwierzę " + currentAnimalIndex + ": " + currentAnimal);

            currentAnimalIndex = (currentAnimalIndex + 1) % numberOfAnimals;
        }
    }

}
