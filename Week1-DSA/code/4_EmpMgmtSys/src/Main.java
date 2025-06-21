import java.util.Scanner;

public class Main {

    static class Employee {
        int employeeId;
        String name;
        String position;
        double salary;

        public Employee(int id, String name, String position, double salary) {
            this.employeeId = id;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return employeeId + " - " + name + " - " + position + " - ₹" + salary;
        }
    }

    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int size = 0;

    // Add employee
    public static void addEmployee(Employee e) {
        if (size < MAX) {
            employees[size++] = e;
            System.out.println("Employee added.");
        } else {
            System.out.println("Cannot add more employees. Array is full.");
        }
    }

    public static Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public static void displayAll() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("Employee Records:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {

                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                size--;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Position: ");
                    String position = sc.nextLine();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    addEmployee(new Employee(id, name, position, salary));
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    Employee result = searchEmployee(searchId);
                    System.out.println(result != null ? result : "Employee not found.");
                    break;

                case 3:
                    displayAll();
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteEmployee(deleteId);
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
