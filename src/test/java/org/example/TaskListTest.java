package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TaskListTest {

        // Vérifie que l'ajout d'une tâche à une liste de tâches fonctionne correctement en vérifiant que l'esception fonctionne egalement
        @Test
        public void testAddTask() {
            TaskList taskList = new TaskList();
            taskList.addTask(new Task(1, "Task 1"));

            assertThrows(IllegalArgumentException.class, () -> {
                taskList.addTask(new Task(1, "Task 2"));
            });
        }

        // Vérifie que la suppression d'une tâche d'une liste de tâches fonctionne correctement
        @Test
        public void testRemoveTask() {
            TaskList taskList = new TaskList();
            Task task = new Task(1, "Acheter des courses");
            taskList.addTask(task);
            assertEquals(1, taskList.getAllTasks().size());
            taskList.removeTask(1);
            assertEquals(0, taskList.getAllTasks().size());
        }

        // Vérifie q'une tâche considéré comme terminée fonctionne correctement
        @Test
        public void testMarkTaskAsDone() {
            TaskList taskList = new TaskList();
            Task task = new Task(1, "Acheter des courses");
            taskList.addTask(task);
            assertFalse(task.isDone());
            taskList.markTaskAsDone(1);
            assertTrue(task.isDone());
        }
}