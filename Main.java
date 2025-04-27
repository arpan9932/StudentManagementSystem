import model.Course;
import  model.Student;
import  service.StudentService;
import  service.CourseService;
import exception.StudentNotFoundException;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        StudentService studentService = new StudentService();
        CourseService courseService =new CourseService();

        while (true) {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Enrolled student with course");
            System.out.println("4. Add grade for student");
            System.out.println("5. View All Students");
            System.out.println("6. Find Student by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1->{
                    System.out.println("Enter course Name : ");
                    String cName=sc.nextLine();
                    System.out.println("Enter course Code : ");
                    String cCode=sc.nextLine();
                    courseService.addCourse(new Course(cCode,cName));
                    System.out.println("course added!");
                }
                case 2->{
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
                case 3 ->{
                    System.out.println("Enter student Id");
                    String sid=sc.nextLine();
                    try {
                        Student student=studentService.findStudentById(sid);
                        System.out.println("Available courses ...");
                        for(Course course:courseService.getCourseList()){
                            System.out.println(course.getCourseCode() +"--"+course.getCourseName());
                        }
                        System.out.println("enter course code to enroll( enter comma if multiple)");
                        String[]codes=sc.nextLine().split(",");
                        for (String code:codes){
                            student.EnrolledCourse(code.trim());
                        }
                        System.out.println("student enrolled in course ");
                    }catch (StudentNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 4 ->{
                    System.out.println("enter student id :");
                    String sid=sc.nextLine();
                    try {
                        Student student = studentService.findStudentById(sid);
                        System.out.println("Enrolled courses ...");
                        for(String code:student.getEnrolledCourse()){
                            Course c=courseService.FindCourseByCode(code);
                            if(c!=null){
                                System.out.println(c.getCourseName()+"("+c.getCourseCode()+")");
                            }
                        }
                        System.out.println("Enter course code to add grade: ");
                        String ccode=sc.nextLine();
                        if(!student.getEnrolledCourse().contains(ccode)){
                            System.out.println("student not enrolled in this course");
                            break;
                        }
                        System.out.println("enter grade:");
                        double grade=sc.nextDouble();
                        student.addGrade(ccode,grade);
                        System.out.println("Grade added");

                    }catch (StudentNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    for (Student s : studentService.getStudentList()) {
                        System.out.println(s.getDetails());
                    }
                }
                case 6 -> {
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
