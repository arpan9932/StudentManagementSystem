package model;

public abstract class Person {
    protected String name;
    protected  int age;
    Person(int age ,String name){
        this.age=age;
        this.name=name;
    }
    public  abstract  String getDetails();
    public String getName(){
        return  name;
    }
    public  int getAge(){
        return  age;
    }
}
