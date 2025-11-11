package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to Task Tracker, an app that allows you to track your tasks and manage your to-do list!");
        System.out.println("Type 'help' to see the list of available commands!\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your command: ");
            String command = scanner.nextLine().trim();

            System.out.println("Command: " + command); //Remove
            checkCommand(command);

            if (command.equals("Q")) {
                System.out.println("Exiting application.");
                break;
            } else if(command.equals("help")){
                printHelp();
            }
        }
        scanner.close();
    }

    private static void checkCommand(String command) {
        String[] parts = command.split("\\s+", 2);
        String mainCommand = parts[0];

        List<String> validCommands = List.of(
                "add", "update", "delete",
                "mark-in-progress", "mark-done",
                "list", "help", "Q"
        );

        if (!validCommands.contains(mainCommand)) {
            System.out.println("Invalid command. Type 'help' to see the list of available commands.");
            return;
        }

        // If "list" has an invalid subcommand → show message
        if (mainCommand.equals("list")) {
            if (parts.length > 1) {
                String sub = parts[1].trim();
                List<String> validSubcommands = List.of("done", "todo", "in-progress");
                if (!validSubcommands.contains(sub)) {
                    System.out.println("Invalid list option. Valid options are: done, todo, in-progress.");
                }
            }
        }
    }


    public static void printHelp() {
        String helpText = """
        Available Commands:
        
        add <description>           Add a new task
        update <id> <description>   Update an existing task
        delete <id>                 Delete a task
        mark-in-progress <id>       Mark a task as in-progress
        mark-done <id>              Mark a task as done
        list                        List all tasks
        list done                   List all completed tasks
        list todo                   List all pending tasks
        list in-progress            List all tasks in progress
        help                        Display this help message
    
        Examples:
              add "Buy groceries"
              update 1 "Buy groceries and cook dinner"
              mark-done 1
              delete 1
        
        """;
        System.out.println(helpText);
    }
}