package io.github.darlene;

abstract class Person{
    private String name;
    private int age;
    private String email;
    private String ID;

    // Constructor for the abstract class
    public Person(int age, String email, String ID){
        this.age = age;
        this.email = email;
        this.ID = ID;
    }
    // Abstract method to be implemented by subclass
    abstract void displayInfo();
}

enum StudentType {
    UNDERGRADUATE,
    GRADUATE,
    PHD
}
class Students extends Person{

    private String [] grades;
    private String [] courses;
    private StudentType studentType;

    // Constructors for the students class
    public Students(int age, String name, String ID, String grades, String[] courses, StudentType studentType){
        super(age, name, ID);
        this.grades = grades.split(",");
        this.courses = courses;
        this.studentType = studentType;
    }
    @Override
    void displayInfo() {

    }
}


class Lecturer extends Person{

    private double salary;
    private String [] courses;


    // Constructor for the Lecturer class
    public Lecturer(int age, String name, String ID, double salary, String [] courses){
        super(age, name, ID);
        this.salary = salary;
        this.courses = courses;

    }
    @Override
    void displayInfo(){

    }
}


class Course {
    private String courseName;
    private String courseCode;
    private Lecturer lecturer;
    private String[] enrolledStudents;
    private static final int  MAX_STUDENTS = 200;

    // Constructors for the course class
    public Course (String courseName, String courseCode, Lecturer lecturer, String[] enrolledStudents){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = enrolledStudents;
    }


}
public class StudentManagementSystem {


    public static void main(String[] args) {

    }
}