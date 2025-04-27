package model;
import  java.util.*;
public class Student extends Person {
    private String studentId;
    private HashMap<String,Double>grades=new HashMap<>();
    private List<String>enrolledCourse=new ArrayList<>();

    public Student(String name,int age,String studentId){
        super(age, name);
        this.studentId=studentId;
    }

    @Override
    public  String getDetails(){
        return "Student: " + name + ", Age: " + age + ", ID: " + studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setGrades(String course,Double grade) {
       grades.put(course, grade);
    }

    public Map<String,Double> getGrades(){
        return grades;
    }

    public void EnrolledCourse(String courseCode){
        enrolledCourse.add(courseCode);
    }

    public  List<String>getEnrolledCourse(){
        return  enrolledCourse;
    }
    public void addGrade(String courseCode,Double grade){
        grades.put(courseCode,grade);
    }
}
