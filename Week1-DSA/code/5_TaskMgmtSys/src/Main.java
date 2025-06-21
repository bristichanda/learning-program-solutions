import java.util.Scanner;

public class Main {

    static class Task {
        int taskId;
        String taskName;
        String status;

        public Task(int id, String name, String status) {
            this.taskId = id;
            this.taskName = name;
            this.status = status;
        }

        @Override
        public String toString() {
            return taskId + " - " + taskName + " [" + status + "]";
        }
    }

    static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static Node head = null;

    public static void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("Task added.");
    }

    public static Task searchTask(int id) {
        Node curr = head;
        while (curr != null) {
            if (curr.task.taskId == id) {
                return curr.task;
            }
            curr = curr.next;
        }
        return null;
    }

    public static void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        System.out.println("Task List:");
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.task);
            curr = curr.next;
        }
    }

    public static void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.task.taskId == id) {
                curr.next = curr.next.next;
                System.out.println("Task deleted.");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Task not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display All Tasks");
            System.out.println("4. Delete Task");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Status: ");
                    String status = sc.nextLine();
                    addTask(new Task(id, name, status));
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    Task found = searchTask(searchId);
                    System.out.println(found != null ? found : "Task not found.");
                    break;

                case 3:
                    displayTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteTask(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
