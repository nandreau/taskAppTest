package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    // Méthode qui permet d'ajouter une tâche à la liste.
    // Elle vérifie d'abord si une tâche avec le même ID existe déjà dans la liste et lance une exception si c'est le cas.
    // Si l'ajout est autorisé, la tâche est ajoutée à la liste.
    public void addTask(Task task) {
        if (tasks.stream().anyMatch(t -> t.getId() == task.getId())) {
            throw new IllegalArgumentException("Une tâche avec le même ID existe déjà");
        }
        tasks.add(task);
    }

    // Méthode qui permet de marquer une tâche comme terminée en cherchant la tâche correspondante dans la liste et en appelant la méthode markAsDone de la classe Task.
    public void markTaskAsDone(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.markAsDone();
                break;
            }
        }
    }

    // méthode qui permet de supprimer une tâche de la liste en utilisant la méthode removeIf de l'interface List.
    public void removeTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }

    // méthode qui retourne simplement la liste de toutes les tâches présentes dans l'objet TaskList.
    public List<Task> getAllTasks() {
        return tasks;
    }
}