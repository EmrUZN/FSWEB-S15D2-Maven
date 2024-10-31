package org.example;

import org.example.entity.Priority;
import org.example.entity.Status;
import org.example.entity.Task;
import org.example.entity.TaskData;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Task> annsTasks = new HashSet<>();
        Task taskAnn = new Task("workintech", "dumy dsc", "ann", Status.IN_PROGRESS, Priority.HIGH);
        Task taskAnn2 = new Task("workintech", "dumy dsc 2", "ann", Status.IN_PROGRESS, Priority.HIGH);
        annsTasks.add(taskAnn);
        annsTasks.add(taskAnn2);



        Set<Task> bobsTasks = new HashSet<>();
        Task taskBob = new Task("workintech", "dumy dsc 3", "bob", Status.IN_PROGRESS, Priority.HIGH);
        Task taskBob2 = new Task("workintech", "dumy dsc 5", "bob", Status.IN_PROGRESS, Priority.HIGH);
        bobsTasks.add(taskBob);
        bobsTasks.add(taskBob2);

        Set<Task> carolTasks = new HashSet<>();
        Task taskCarol = new Task("workintech", "dumy dsc 4", "carol", Status.IN_PROGRESS, Priority.HIGH);
        Task taskCarol2 = new Task("workintech", "dumy dsc 3", "carol", Status.IN_PROGRESS, Priority.HIGH);
        carolTasks.add(taskCarol);
        carolTasks.add(taskCarol2);

        Set<Task> unassignedTasks = new HashSet<>();
        Task taskUnassigned = new Task("workintech", "dumy dsc 6", null, Status.IN_PROGRESS, Priority.HIGH);
        unassignedTasks.add(taskUnassigned);
        TaskData taskData = new TaskData(annsTasks,bobsTasks, carolTasks,unassignedTasks);
        System.out.println("bobstasks: "+ taskData.getTasks("bob"));
        System.out.println("annstasks: "+ taskData.getTasks("ann"));
        System.out.println("alltasks: "+ taskData.getTasks("all"));

        taskData.getIntersection(annsTasks,bobsTasks);
        taskData.getIntersection(annsTasks,carolTasks);
        taskData.getIntersection(bobsTasks,carolTasks);

        System.out.println("unnasigned: " + taskData.getDifferences(unassignedTasks, taskData.getTasks("ann")));
    }
}