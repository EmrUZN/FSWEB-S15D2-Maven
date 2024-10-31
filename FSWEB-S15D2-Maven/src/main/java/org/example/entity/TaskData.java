package org.example.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolTasks, Set<Task> unassignedTasks) {
    }

    public Set<Task> getTasks(String name){
        switch (name){
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                return getUnion(bobsTasks,annsTasks,carolsTasks);
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(Set<Task> ... sets) {
        HashSet<Task> allTasks = new LinkedHashSet<>();
        for (Set<Task> tasks: sets){
            allTasks.addAll(tasks);
        }
        return null;
    }
    public Set<Task> getIntersection(Set<Task> first, Set<Task> second){
        Set<Task> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }
    public Set<Task> getDifferences(Set<Task> first, Set<Task> second){
        Set<Task> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference; }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }
}
