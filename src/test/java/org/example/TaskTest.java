package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TaskTest {

    // Vérifie la création d'une tâche en créant une nouvelle tâche avec un identifiant et une description tout en vérifiant que ces valeurs sont correctement initialisées
    // Elle vérifie également que la tâche n'est pas marquée comme terminée (isDone() renvoie false)
    @Test
    public void testTaskCreation() {
        Task task = new Task(1, "Acheter des courses");
        assertEquals(1, task.getId());
        assertEquals("Acheter des courses", task.getDescription());
        assertFalse(task.isDone());
    }

    // Vérifie et teste les méthodes set et get de la classe Task
    @Test
    public void testGetId() {
        Task task = new Task(1, "Acheter des courses");
        assertEquals(1, task.getId());
    }

    @Test
    public void testSetId() {
        Task task = new Task(1, "Acheter des courses");
        task.setId(2);
        assertEquals(2, task.getId());
    }

    @Test
    public void testGetDescription() {
        Task task = new Task(1, "Acheter des courses");
        assertEquals("Acheter des courses", task.getDescription());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task(1, "Acheter des courses");
        task.setDescription("Faire du sport");
        assertEquals("Faire du sport", task.getDescription());
    }

    @Test
    public void testIsDone() {
        Task task = new Task(1, "Acheter des courses");
        assertFalse(task.isDone());
    }

    @Test
    public void testSetDone() {
        Task task = new Task(1, "Acheter des courses");
        task.setDone(true);
        assertTrue(task.isDone());
    }

    @Test
    public void testMarkAsDone() {
        Task task = new Task(1, "Acheter des courses");
        task.markAsDone();
        assertTrue(task.isDone());
    }
}