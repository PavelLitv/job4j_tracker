package ru.job4j.collection.comparator;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        return job2.getName().compareTo(job1.getName());
    }
}
