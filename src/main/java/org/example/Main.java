package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to Task Tracker, an app that allows you to track your tasks and manage your to-do list!\n");
        System.out.println("Type 'help' to see the list of available commands!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your command: ");
            String command = scanner.nextLine().trim();

            System.out.println("Command: " + command);

            if (command.equals("Q")) {
                System.out.println("End of program.");
                break;
            } else if(command.equals("help")){
                printHelp();
            }
        }
        scanner.close();
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