package org.example.task10_tasks;

import java.util.ArrayList;

import static java.util.Comparator.comparing;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public ArrayList<Task> getTasks(){
        return  tasks;
    }

    public void sortTasksList(){
        tasks.sort(comparing(Task::getPriority));
        System.out.println(tasks);
    }
}
