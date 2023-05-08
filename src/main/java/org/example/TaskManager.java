package org.example;

public class TaskManager {
    TaskList taskList;
    private ConsoleInputOutput consoleIO;

    public TaskManager(ConsoleInputOutput consoleIO) {
        this.taskList = new TaskList(); // Initialise la liste de tâches
        this.consoleIO = consoleIO; // Initialise l'entrée/sortie console
    }

    /**
     * Démarre le gestionnaire de tâches en boucle tant que l'utilisateur ne saisit pas "exit"
     */
    public void start() {
        String input = "";
        while (!input.equals("exit")) {
            consoleIO.printMenu(); // Affiche le menu
            input = consoleIO.getInput(); // Récupère l'entrée utilisateur
            switch (input) {
                case "1":
                    addTask(consoleIO); // Ajoute une tâche
                    break;
                case "2":
                    markTaskAsDone(consoleIO); // Marque une tâche comme terminée
                    break;
                case "3":
                    removeTask(consoleIO); // Supprime une tâche
                    break;
                case "4":
                    printAllTasks(consoleIO); // Affiche toutes les tâches
                    break;
                case "exit":
                    break;
                default:
                    consoleIO.printMessage("Entrée invalide"); // Affiche un message d'erreur si l'entrée est invalide
                    break;
            }
        }
    }

    /**
     * Ajoute une tâche à la liste de tâches
     */

    void addTask(ConsoleInputOutput consoleIO) {
        consoleIO.printMessage("Entrez la description de la tâche :"); // Demande une description de tâche
        String description = consoleIO.getInput(); // Récupère la description
        Task task = new Task(taskList.getAllTasks().size() + 1, description); // Crée une nouvelle tâche
        taskList.addTask(task); // Ajoute la tâche à la liste
        consoleIO.printMessage("Tâche ajoutée"); // Affiche un message de confirmation
    }

    /**
     * Marque une tâche comme terminée
     */
    void markTaskAsDone(ConsoleInputOutput consoleIO) {
        consoleIO.printMessage("Entrez l'ID de la tâche à marquer comme terminée :"); // Demande l'ID de la tâche à marquer comme terminée
        int taskId = Integer.parseInt(consoleIO.getInput()); // Récupère l'ID
        taskList.markTaskAsDone(taskId); // Marque la tâche comme terminée
        consoleIO.printMessage("Tâche marquée comme terminée"); // Affiche un message de confirmation
    }

    /**
     * Supprime une tâche de la liste
     */
    void removeTask(ConsoleInputOutput consoleIO) {
        consoleIO.printMessage("Entrez l'ID de la tâche à supprimer :"); // Demande l'ID de la tâche à supprimer
        int taskId = Integer.parseInt(consoleIO.getInput()); // Récupère l'ID
        taskList.removeTask(taskId); // Supprime la tâche de la liste
        consoleIO.printMessage("Tâche supprimée"); // Affiche un message de confirmation
    }

    /**
     * Affiche toutes les tâches de la liste
     */
    void printAllTasks(ConsoleInputOutput consoleIO) {
        consoleIO.printMessage("Liste des tâches:");
        for (Task task : taskList.getAllTasks()) {
            // Affiche les informations de chaque tâche, y compris son ID, sa description et son statut
            consoleIO.printMessage(task.getId() + ". " + task.getDescription() + " (" + (task.isDone() ? "terminé" : "non terminé") + ")");
        }
    }
}
