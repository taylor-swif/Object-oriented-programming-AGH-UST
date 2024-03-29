package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import agh.ics.oop.model.*;

public class SimulationEngine {
    private final List<Simulation> simulations;

    private final ExecutorService executorService;

    public SimulationEngine(List<Simulation> simulations, int n) {
        this.simulations = simulations;
        this.executorService = Executors.newFixedThreadPool(n);

    }

    public void runAsyncInThreadPool() {
        for (Simulation simulation : simulations) {
            executorService.submit(simulation);
        }
    }

    public void awaitSimulationsEnd() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                    System.err.println("Thread pool did not terminate.");                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) {

//        MapChangeListener drawer = new ConsoleMapDisplay();
//
//
//        List<MoveDirection> moves = List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT);
//
//        List<Simulation> simulations = new ArrayList<>();
//
//        for (int i = 0; i < 10000; i++) {
//            RectangularMap rectangularMap = new RectangularMap(5, 5, i*2);
//            GrassField grassField = new GrassField(4, i*2 + 1);
//
//            rectangularMap.subscribe("drawer", drawer);
//            grassField.subscribe("drawer", drawer);
//
//            simulations.add(new Simulation(List.of(new Vector2d(2, 2), new Vector2d(3, 4)), moves, rectangularMap));
//            simulations.add(new Simulation(List.of(new Vector2d(2, 2), new Vector2d(3, 4)), moves, grassField));
//        }
//
//        SimulationEngine engine = new SimulationEngine(simulations, 4);
//        engine.runAsyncInThreadPool();
//        engine.awaitSimulationsEnd();


        RectangularMap rectangularMap = new RectangularMap(5, 5, 1);
        List<MoveDirection> moves = List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD);
        MapChangeListener drawer = new ConsoleMapDisplay();
        rectangularMap.subscribe("drawer", drawer);
        Simulation simulation = new Simulation(List.of(new Vector2d(2, 2), new Vector2d(3, 4)), moves, rectangularMap);
        SimulationEngine engine = new SimulationEngine(new ArrayList<>(List.of(simulation)), 4);
        engine.runAsyncInThreadPool();
        engine.awaitSimulationsEnd();

        System.out.println("The system has finished running.");    }
}

