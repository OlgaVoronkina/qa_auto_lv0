package org.example.task10_tasks;
/**
 * Создайте класс Task с полями для описания задачи и ее приоритета
 * В классе TaskManager используйте ArrayList<Task> для хранения списка задач
 * Реализуйте методы для добавления задачи в список, удаления задачи из списка и сортировки списка задач по приоритету перед выводом
 */
public class Task {
    private String task;
    private int priority;

    public int getPriority() {
        return priority;
    }

    public Task(String task, int priority) {
        this.task = task;
        this.priority = priority;
    }

    public Task(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task='" + task + '\'' +
                ", priority=" + priority +
                '}';
    }
}
