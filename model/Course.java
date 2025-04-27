package model;

public class Course {
    public String CourseName;
    public String CourseCode;
    public Course(String CourseCode,String CourseName){
        this.CourseCode=CourseCode;
        this.CourseName=CourseName;
    }
    public  String getCourseName(){
        return  CourseName;
    }
    public  String getCourseCode(){
        return  CourseCode;
    }
    @Override
    public String toString(){
        return  CourseName +"("+CourseCode+")";
    }
}
