package ru.job4j.collection.comparator;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        return Integer.compare(job2.getPriority(), job1.getPriority());
    }
}
