package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (char element : evenElements) {
            if (count % 2 == 0) {
                result.append(element);
            }
            count++;
        }
        return result.toString();
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        int count = descendingElements.size();
        for (int i = 0; i < count; i++) {
            result.append(descendingElements.pollLast());
        }
        return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
