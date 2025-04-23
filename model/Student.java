package model;
import  java.util.*;
public class Student extends Person {
    private String studentId;
    private HashMap<String,Double>grades=new HashMap<>();

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
}
