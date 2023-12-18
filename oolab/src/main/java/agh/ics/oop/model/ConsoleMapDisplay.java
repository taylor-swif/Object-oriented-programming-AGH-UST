package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{

    private int updateCounter = 1;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized (this){
            System.out.println("Map ID: " + worldMap.getId());
            System.out.println(message);
            System.out.println(worldMap);
            System.out.println("Counted updates: " + updateCounter);

            updateCounter += 1;
        }
    }
}
