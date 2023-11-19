package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TextMapTest {

    @Test
    void move() {
        WorldMap<String, Integer> textMap = new TextMap();

        ArrayList<String> words = new ArrayList<>();
        words.add("Ala");
        words.add("ma");
        words.add("sowoniedźwiedzia");

        for (String word : words) {
            textMap.place(word);
        }

        textMap.move(textMap.objectAt(1), MoveDirection.FORWARD);
        textMap.move(textMap.objectAt(2), MoveDirection.BACKWARD);
        textMap.move(textMap.objectAt(0), MoveDirection.BACKWARD);
        textMap.move(textMap.objectAt(2), MoveDirection.FORWARD);


        assertEquals("[Ala, ma, sowoniedźwiedzia]", textMap.toString());
    }
}