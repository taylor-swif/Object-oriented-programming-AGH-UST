package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{

    private int updateCounter = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println(message);
        System.out.println(worldMap);
        System.out.println("Counted updates: " + updateCounter);

        updateCounter += 1;
    }
}
