package agh.ics.oop.model;

import java.util.*;

import agh.ics.oop.model.util.MapVisualizer;


public abstract class AbstractWorldMap implements WorldMap<Animal, Vector2d> {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final Map<Vector2d, Grass> grasses = new HashMap<>();
    final Map<String, List<MapChangeListener>> listeners = new HashMap<>();
    protected MapVisualizer map = new MapVisualizer(this);
    protected Boundary bounds;

    private final int id;

    protected AbstractWorldMap(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return map.draw(getCurrentBounds());
    }

    public void place(Animal animal) throws PositionAlreadyOccupiedException{

        if (canMoveTo(animal.getPosition())) {
            changeMapBounds(animal.getPosition());
            animals.put(animal.getPosition(), animal);
            notify("drawer", "animal placed to position " + animal.getPosition());

        } else throw new PositionAlreadyOccupiedException(animal.getPosition());

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return animals.get(position) != null;
    }

    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        MapDirection oldOrientation = animal.getOrientation();
        animal.move(direction, this);

        if (oldPosition != animal.getPosition()){
            animals.put(animal.getPosition(), animals.remove(oldPosition));
            notify("drawer", "animal moved to position " + animal.getPosition());
        } else if (oldOrientation != animal.getOrientation()) {
            notify("drawer", "animal changed orientation to " + animal.getOrientation());
        }

    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.get(position) != null) {
            return (WorldElement) animals.get(position);
        } else if (grasses.get(position) != null) {
            return (WorldElement) grasses.get(position);
        }
        else {
            return null;
        }
    }

    public void changeMapBounds(Vector2d elementPosition) {
        bounds = new Boundary(bounds.lowerLeft().lowerLeft(elementPosition), bounds.upperRight().upperRight(elementPosition));
    }

    @Override
    public Map<Vector2d, WorldElement> getElements() {
        Map<Vector2d, WorldElement> result = new HashMap<>(animals);
        result.putAll(grasses);
        return result;
    }

    public Boundary getCurrentBounds(){
        return bounds;
    }

    protected void eventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, MapChangeListener listener) {
        List<MapChangeListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, MapChangeListener listener) {
        List<MapChangeListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, String message) {
        List<MapChangeListener> users = listeners.get(eventType);
        for (MapChangeListener listener : users) {
            listener.mapChanged(this, message);
        }
    }

    public int getId() {
    	return id;
    }
}