package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskManagerTest {

    // Vérifie si l'option "exit" du menu affiché dans la console est correctement gérée par la fonction start() de la classe TaskManager.
    @Test
    public void testMenuExit(){
        ConsoleInputOutput consoleIOMock = mock(ConsoleInputOutput.class);

        when(consoleIOMock.getInput())
                .thenReturn("1")
                .thenReturn("exit");

        TaskManager target = new TaskManager(consoleIOMock);
        target.start();

        verify(consoleIOMock, times(2)).printMenu();
    }

    // Vérifie si la fonction addTask() de la classe TaskManager ajoute une tâche correctement
    // en appelant les méthodes appropriées de l'objet ConsoleInputOutput passé en paramètre.
    @Test
    public void testAddTask(){
        ConsoleInputOutput consoleIOMock = mock(ConsoleInputOutput.class);

        when(consoleIOMock.getInput())
                .thenReturn("Task description");

        TaskManager target = new TaskManager(consoleIOMock);
        target.addTask(consoleIOMock);

        verify(consoleIOMock).printMessage("Entrez la description de la tâche :");
        verify(consoleIOMock).getInput();
        verify(consoleIOMock).printMessage("Tâche ajoutée");
    }

    // Vérifie si la fonction markTaskAsDone() de la classe TaskManager marque correctement une tâche comme terminée
    // en appelant les méthodes appropriées de l'objet ConsoleInputOutput passé en paramètre et de l'objet TaskList associé.

    @Test
    public void testMarkTaskAsDone(){
        ConsoleInputOutput consoleIOMock = mock(ConsoleInputOutput.class);
        TaskList taskListMock = mock(TaskList.class);

        when(consoleIOMock.getInput())
                .thenReturn("1");

        TaskManager target = new TaskManager(consoleIOMock);
        target.taskList = taskListMock;
        target.markTaskAsDone(consoleIOMock);

        verify(consoleIOMock).printMessage("Entrez l'ID de la tâche à marquer comme terminée :");
        verify(consoleIOMock).getInput();
        verify(taskListMock).markTaskAsDone(1);
        verify(consoleIOMock).printMessage("Tâche marquée comme terminée");
    }

    // Vérifie si la fonction removeTask() de la classe TaskManager supprime correctement une tâche
    // en appelant les méthodes appropriées de l'objet ConsoleInputOutput passé en paramètre et de l'objet TaskList associé.
    @Test
    public void testRemoveTask(){
        ConsoleInputOutput consoleIOMock = mock(ConsoleInputOutput.class);
        TaskList taskListMock = mock(TaskList.class);

        when(consoleIOMock.getInput())
                .thenReturn("1");

        TaskManager target = new TaskManager(consoleIOMock);
        target.taskList = taskListMock;
        target.removeTask(consoleIOMock);

        verify(consoleIOMock).printMessage("Entrez l'ID de la tâche à supprimer :");
        verify(consoleIOMock).getInput();
        verify(taskListMock).removeTask(1);
        verify(consoleIOMock).printMessage("Tâche supprimée");
    }

    // Vérifie si la fonction printAllTasks() de la classe TaskManager affiche correctement la liste de toutes les tâches en appelant les méthodes appropriées de l'objet ConsoleInputOutput passé en paramètre et de l'objet TaskList associé.
    @Test
    public void testPrintAllTasks(){
        ConsoleInputOutput consoleIOMock = mock(ConsoleInputOutput.class);
        TaskList taskListMock = mock(TaskList.class);

        when(taskListMock.getAllTasks())
                .thenReturn(List.of(new Task(1, "Task 1"), new Task(2, "Task 2")));

        TaskManager target = new TaskManager(consoleIOMock);
        target.taskList = taskListMock;
        target.printAllTasks(consoleIOMock);

        verify(consoleIOMock).printMessage("Liste des tâches:");
        verify(consoleIOMock).printMessage("1. Task 1 (non terminé)");
        verify(consoleIOMock).printMessage("2. Task 2 (non terminé)");
    }
}