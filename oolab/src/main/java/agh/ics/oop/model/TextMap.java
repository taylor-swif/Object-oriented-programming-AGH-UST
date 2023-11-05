package agh.ics.oop.model;

import java.util.ArrayList;

import static java.util.Collections.swap;

public class TextMap implements WorldMap<String, Integer> {
    private ArrayList<String> textList = new ArrayList<>();

    @Override
    public boolean place(String element) {
        textList.add(element);
        return true;
    }

    @Override
    public void move(String animal, MoveDirection direction) {

        switch (direction){
            case FORWARD -> {
                if (textList.indexOf(animal) + 1 != textList.size()) {
                    swap(textList, textList.indexOf(animal), textList.indexOf(animal) + 1);
                }
            }
            case BACKWARD -> {
                if (textList.indexOf(animal) - 1 != -1) {
                    swap(textList, textList.indexOf(animal), textList.indexOf(animal) - 1);
                }
            }
            case RIGHT, LEFT -> {
                return;
            }

        }

    }

    @Override
    public String objectAt(Integer position) {
        if (position >= 0 && position < textList.size()) {
            return textList.get(position);
        }
        return null;
    }

    @Override
    public boolean isOccupied(Integer position) {
        return position >= 0 && position < textList.size();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public String toString() {
        return textList.toString();
    }
}
