package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Model
        Student student = new Student("Alice", "S101", "A");

        // View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        // Display initial data
        controller.updateView();

        System.out.println("\nUpdating student grade...\n");

        // Modify data
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}