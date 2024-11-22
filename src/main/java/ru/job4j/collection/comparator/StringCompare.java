package ru.job4j.collection.comparator;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftLength = left.length();
        int rightLength = right.length();
        int length = Math.min(leftLength, rightLength);
        for (int i = 0; i < length; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return Character.compare(left.charAt(i), right.charAt(i));
            }
        }
        if (leftLength != rightLength) {
            return Integer.compare(leftLength, rightLength);
        }
        return 0;
    }
}
