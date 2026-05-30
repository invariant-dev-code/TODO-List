import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scn = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println("=== TO-DO LIST ===");
            System.out.println("1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Update Task");
            System.out.println("5. Exit");
            System.out.print("Please choose: ");

            choice = scn.nextInt();
            scn.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.println("Enter the task you want to add:");
                    String task = scn.nextLine();

                    tasks.add(task);
                    System.out.println("Task added.");
                    break;

                case 2:
                    showTasks(tasks);
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("Task list is empty.");
                        break;
                    }

                    showTasks(tasks);

                    System.out.println("Which task number do you want to remove?");
                    int index = scn.nextInt();

                    if (index >= 0 && index < tasks.size()) {
                        tasks.remove(index);
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Incorrect choice.");
                    }

                    break;

                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("Task list is empty.");
                        break;
                    }

                    showTasks(tasks);

                    System.out.println("Enter the task number you want to update:");
                    int indexUpdate = scn.nextInt();

                    if (indexUpdate >= 0 && indexUpdate < tasks.size()) {

                        System.out.println("Task found: " + tasks.get(indexUpdate));

                        System.out.println("Enter the new task:");
                        scn.nextLine();

                        String newTask = scn.nextLine();
                        tasks.set(indexUpdate, newTask);

                        System.out.println("Task updated.");

                    } else {
                        System.out.println("Incorrect choice.");
                    }

                    break;

                case 5:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Incorrect choice.");
            }

        } while (choice != 5);

        scn.close();

    }

    public static void showTasks(ArrayList<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        } else {
            System.out.println("===Tasks===");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
}
