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

            if (command.equals("Q")) {
                System.out.println("Exiting application.\n");
                break;
            } else if(command.equals("help")){
                printHelp();
            }

            boolean commandValid = checkCommand(command);

            if(commandValid) {
                System.out.println("COMMAND CORRECT: " + command);
            }
        }
        scanner.close();
    }

    private static boolean checkCommand(String command) {
        String[] parts = command.split("\\s+");
        String mainCommand = parts[0];

        List<String> validCommands = List.of(
                "add", "update", "delete",
                "mark-in-progress", "mark-done",
                "list", "help", "Q"
        );

        if (!validCommands.contains(mainCommand)) {
            System.out.println("Invalid command. Type 'help' to see the list of available commands.\n");
            return false;
        } else if(mainCommand.equals("update")) {
            if (parts.length > 2) {
                String idPart = parts[1].trim();
                System.out.println("idPart: " + idPart);
                if (isNumeric(idPart)) {
                    System.out.println("Invalid command format. The second argument must be a task ID number.\n");
                    return false;
                }
            } else {
                System.out.println("Invalid command format. The second argument must be a task ID number and the third a new description.\n");
                return false;
            }
        } else if (mainCommand.equals("list")) {
            if (parts.length > 1) {
                String sub = parts[1].trim();
                List<String> validSubcommands = List.of("done", "todo", "in-progress");
                if (!validSubcommands.contains(sub)) {
                    System.out.println("Invalid list option. Valid options are: done, todo, in-progress.\n");
                    return false;
                }
            }
        } else if (mainCommand.equals("delete") || mainCommand.equals("mark-in-progress") || mainCommand.equals("mark-done")) {
            if (parts.length > 1) {
                String idPart = parts[1].trim();
                if (isNumeric(idPart)) {
                    System.out.println("Invalid command format. The second argument must be a task ID number.\n");
                    return false;
                }
            } else {
                System.out.println("Missing task ID. Usage example: '" + mainCommand + " <id>'.\n");
                return false;
            }
        }
        return true;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
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