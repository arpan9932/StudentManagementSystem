import  model.Student;
import  service.StudentService;
import exception.StudentNotFoundException;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        StudentService studentService = new StudentService();

        while (true) {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Find Student by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1->{
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();
                    Student st=new Student(name,age,id);
                    studentService .addStudent(st);
                    System.out.println("Student added!");
                }
                case 2 -> {
                    for (Student s : studentService.getStudentList()) {
                        System.out.println(s.getDetails());
                    }
                }
                case 3 -> {
                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();
                    try {
                        Student s = studentService.findStudentById(id);
                        System.out.println(s.getDetails());
                        System.out.println("Grades: " + s.getGrades());
                    } catch (StudentNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
