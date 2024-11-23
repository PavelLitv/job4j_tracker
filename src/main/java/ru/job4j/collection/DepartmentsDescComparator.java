package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                if (i < left.split("/")[0].length()) {
                    return Character.compare(right.charAt(i), left.charAt(i));
                } else {
                    return Character.compare(left.charAt(i), right.charAt(i));
                }
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
