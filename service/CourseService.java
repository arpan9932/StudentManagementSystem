package service;
import model.Course;
import model.Student;

import java.util.*;
public class CourseService {
    private  List<Course>courseList=new ArrayList<>();

    public void addCourse(Course course){
        for(Course c:courseList){
            if(c.getCourseCode().equalsIgnoreCase(course.getCourseCode())){
                System.out.println("course code already exits...");
                return;
            }
        }
        courseList.add(course);
    }
    public  Course FindCourseByCode(String  code){
        for(Course course:courseList){
            if(course.getCourseCode().equalsIgnoreCase(code)) {
                return course;
            }
        }
        return  null;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
}
