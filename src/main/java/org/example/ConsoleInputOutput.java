package org.example;

import java.util.Scanner;

public class ConsoleInputOutput {
    private Scanner scanner;

    public ConsoleInputOutput() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMenu() {
        System.out.println("Choisissez une option :");
        System.out.println("1. Ajouter une tâche");
        System.out.println("2. Rendre une tâche comme terminée");
        System.out.println("3. Supprimer une tâche");
        System.out.println("4. Afficher toutes les tâches");
        System.out.println("Tapez 'exit' pour quitter");
    }
}






