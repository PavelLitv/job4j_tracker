package ru.job4j.stream;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(s -> new Tuple(
                        s.name(),
                        s.subjects().stream()
                                .mapToInt(Subject::score)
                                .average()
                                .orElse(0D)
                ))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.subjects().stream())
                .collect(
                        groupingBy(
                                Subject::name,
                                LinkedHashMap::new,
                                averagingDouble(Subject::score)
                        ))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(s -> new Tuple(
                        s.name(),
                        s.subjects().stream()
                                .mapToInt(Subject::score)
                                .sum()
                ))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.subjects().stream())
                .collect(groupingBy(
                                Subject::name,
                                LinkedHashMap::new,
                                summingDouble(Subject::score)
                        )
                )
                .entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .orElse(null);
    }
}
