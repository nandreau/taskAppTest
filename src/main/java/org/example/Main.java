package org.example;

public class Main {
    public static void main(String[] args) {
        ConsoleInputOutput console = new ConsoleInputOutput();
        TaskManager taskManager = new TaskManager(console);
        taskManager.start();
    }
}