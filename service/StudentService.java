package service;
import model.Student;
import  exception.StudentNotFoundException;
import  java.util.*;
public class StudentService {
    private List<Student>studentList=new ArrayList<>();
    StudentService(Student s){
        studentList.add(s);
    }
    public Student findStudentById(String id) throws StudentNotFoundException {
        return studentList.stream()
                .filter(s -> s.getStudentId().equals(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found."));
    }
    public List<Student> getStudentList(){
        return studentList;
    }
}
