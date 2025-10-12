package io.github.darlene;
import java.util.*;

abstract class Person{
    private String name;
    private int age;
    private String email;
    private String ID;

    // Constructor for the abstract class
    public Person(String name,int age, String email, String ID){
        this.name = name;
        this.age = age;
        this.email = email;
        this.ID = ID;
    }

    // Getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }

    // Abstract method to be implemented by subclass
    abstract void displayInfo();
}





// ==============================================
// STUDENT CLASS
// ==============================================


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
    public Students(int age, String name, String ID, String email, String [] grades, String[] courses, StudentType studentType){
        super( name, age, email, ID);
        this.grades = grades;
        this.courses = courses;
        this.studentType = studentType;
    }

    // Getters and setters
    public String [] getGrades(){
        return grades;
    }
    public void setGrades(String[] grades){
        this.grades = grades;
    }
    public String [] getCourses(){
        return courses;
    }
    public void setCourses(String[] courses){
        this.courses = courses;
    }
    public StudentType getStudentType(){
        return studentType;
    }
    public void setStudentType(StudentType studentType){
        this.studentType = studentType;
    }


    // Method to enroll in a course
    public boolean requestEnrollCourse(CourseManager courses){
        // Checks if the course is full




        return true;
    }

    // Method to drop a course

    public boolean dropCourse(){

        return true;
    }

    // Method to add Grade


    // Method to calculate GPA


    @Override
    void displayInfo() {
        System.out.println("Name" + getName());
        System.out.println("Age" + getAge());
        System.out.println("ID" + getID());
        System.out.println("ID" + getID());

    }
}

// ==============================================
// LECTURER (TEACHER) CLASS
// ==============================================
class Lecturer extends Person{

    private double salary;
    private String [] courses;


    // Constructor for the Lecturer class
    public Lecturer(int age, String name, String email, String ID, double salary, String [] courses){
        super(name, age,email, ID);
        this.salary = salary;
        this.courses = courses;

    }

    // Getters and setters
    public double getSalary(){
        return salary;
    }
    public void setSalary(){
        this.salary = salary;
    }
    public String [] getCourses(){
        return courses;
    }
    public void setCourses(String[] courses){
        this.courses = courses;
    }

    // Method to assign Grade


    // Method to

    // Method to display all info...Overrides the person abstract
    @Override
    void displayInfo(){
        System.out.println("Name" + getName());
        System.out.println("Age" + getAge());
        System.out.println("ID" + getID());
        System.out.println("ID" + getID());
    }
}


// ==============================================
// COURSES CLASS
// ==============================================


class CourseManager {
    private String courseName;
    private String courseCode;
    private Lecturer lecturer;
    private Students [] enrolledStudents;
    private int studentCount;
    private static final int  MAX_STUDENTS = 200;

    // Constructors for the course class
    public CourseManager (String courseName, String courseCode, Lecturer lecturer, Students [] enrolledStudents, int studentCount){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new Students[MAX_STUDENTS];
        this.studentCount = 0;
        this.lecturer = lecturer;
    }

    // Method to add a course
    public boolean addCourse(){
        //Check if course exists



        return true;
    }


    // Method to remove a course
    public boolean removeCourse(){




        return true;
    }

    // Method to update a course


    // Method to search course by code

    //can enroll student in course
    public boolean canEnroll(){
        if(studentCount == MAX_STUDENTS){
            System.out.println("Course is full, can't add more students");
            return false;
        }
        System.out.println("Can enroll student.");
        return true;
    }

    // can add student in course
    public boolean canAddStudent(Students student){
        if (canEnroll()){
            enrolledStudents[studentCount] = student;
            studentCount++;
            System.out.println("Student added successfully!");
            return true;
        } else{
            System.out.println("Student not added successfully!");
        }
        return false;
    }


    // Method to check if course exists


    //Method to display all existing courses

    // Method to filter by lecturer


    // Method to filter by semester


    // Method to display course information


}

// ==============================================
// MAIN UNIVERSITY CLASS
// ==============================================

class University{

    private Students [] students;
    private Lecturer [] lecturer;
    private CourseManager [] courses;

    // Method to add student

    // Method to add Lecturer


    // Method to enroll student in course


    // Method to display all students

    // Method to display all courses


    // Method to search student


    // Method to display University info

}
public class StudentManagementSystem {


    public static void main(String[] args) {

    }
}