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

class Student extends Person{

    private String [] grades;
    private String [] courses;
    private StudentType studentType;
    private final static int MAXIMUM_COURSE_ENROLLED = 5;
    private CourseManager course;

    // Constructors for the students class
    public Student(int age, String name, String ID, String email, String [] grades, String[] courses, StudentType studentType){
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
    public boolean requestEnrollCourse(CourseManager course){
        // Checks if the course is available using the isAvailable method in CourseManageer
        if(CourseManager.course == null){
            System.out.println("Course does not exist");
            return false;
        }
        // Check if their course limit is full
        if (CourseManager.){

        }



        return true;
    }

    // Method to request to drop a course

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

    // Method to request to be enrolled to the course


    // Method to assign Grade


    // Method to display all info...Overrides the person abstract
    @Override
    void displayInfo(){
        System.out.println("Name" + getName());
        System.out.println("Age" + getAge());
        System.out.println("ID" + getID());
        System.out.println("ID" + getID());
    }
}



class Course {
    private String courseName;
    private String courseCode;
    private Student [] enrolledStudents;
    private int studentCount;
    private static final int  MAX_STUDENTS = 200;
    private boolean isAvailable;


    // Constructors
    public Course(Student [] enrolledStudents, int studentCount, String courseName, String courseCode){
        this.enrolledStudents = new Student[MAX_STUDENTS];
        this.studentCount = 0;
        this.courseName = courseName;
        this.courseCode = courseName;
    }

    // Getters
    public String getCourseName(){
        return courseName;
    }
    public String getCourseCode(){
        return courseCode;
    }


    //Check if it can enroll student in course
    public boolean canEnrollStudent(){
        if(studentCount == MAX_STUDENTS){
            System.out.println("Course is full, can't add more students");
            return false;
        }
        System.out.println("Can enroll student.");
        return true;
    }

    // can add student in course
    public boolean canAddStudent(Student student){
        if (canEnrollStudent()){
            enrolledStudents[studentCount] = student;
            studentCount++;
            System.out.println("Student added successfully!");
            return true;
        }
        System.out.println("Student not added successfully!");
        return false;
    }


    public void displayInfo(){
        System.out.println("=========================================================");
        System.out.println("===================" +  ("Get the Course Statistics") + "===================================");
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Course Code: " + getCourseCode());
        System.out.println("Number of students enrolled: " + studentCount);

    }

}


// ==============================================
// COURSE MANAGER CLASS
// ==============================================


class CourseManager {
    private String courseName;
    private String courseCode;
    private Lecturer lecturers [];
    private Course courses [];
    private int  enrolledLecturers;
    private int enrolledCourses;
    private static final int MAX_LECTURERS = 10;
    public static final int MAX_COURSES = 50;
    private boolean isAvailable;

    // Constructors for the course class
    public CourseManager (int enrolledCourses, int enrolledLecturers, boolean isAvailable){
        this.enrolledCourses = 0;
        this.enrolledLecturers = 0;
        this.isAvailable = false;

    }

    // check for duplicate and if is space to add more lecturers
    public boolean canEnrollLecturer(Lecturer lecturer){
        // Check for duplicate lecturer ID
        for (int i = 0; i < enrolledLecturers; i++){
            if(lecturers[i].getID().equals(lecturer.getID())){
                System.out.println("Lecturer: " + lecturer.getID() + lecturer.getName());
                System.out.println("Duplicate lecturer ID cannot enroll the lecturer");
            }
        }

        if (enrolledLecturers == MAX_LECTURERS){
            System.out.println("Course is full, can't add more lecturers");
        }
        System.out.println("Can enroll lecturer");
        return true;
    }

    // Add a lecture
    public void AddLecture(Lecturer lecturer){
        if(canEnrollLecturer(lecturer)){
            lecturers[enrolledLecturers] = lecturer;
            enrolledLecturers++;
            System.out.println("Lecturer enrolled successfully!");
        }
        System.out.println("Lecturer not enrolled.");

    }

    // Check if the course is available
    public boolean isAvailable(Course course){
        // Check for duplicate course code
        for (int i = 0; i < enrolledCourses; i++){
            if(courses[i].getCourseCode().equals(course.getCourseCode())){
                System.out.println("Course: " + course.getCourseName() + course.getCourseCode());
                System.out.println("Duplicate Course code cannot enroll the course");
                return true;
            }
        }
        return false;
    }

    // Check if there is space to enroll a course
    public boolean canEnrollCourse(Course course){
        if (enrolledCourses == MAX_COURSES){
            System.out.println("Course is full,");
            return false;
        }
        System.out.println("Can enroll a new course");
        return true;
    }
// CHECK HERE TO SEE WHICH ONE WEIGHS MORE && OR || THE CONDITION IS SUPPOSED TO BE IS THE COURSE IS AVAILABLE AND THERE IS SPACE OR NO SPACE DO NOT ADD...


    // Method to add a course
    public boolean addCourse(Course course){
        if (isAvailable(course) || canEnrollCourse(course)){
            System.out.println("Can not add a course");
        }

        System.out.println("Enrolling the new course to our system.............");
        courses[enrolledCourses] = course;
        enrolledCourses++;
        System.out.println("Success course Added.");
        return true;
    }

    // Method to remove a course // After removing we will have to go a string back in the array..
    public boolean removeCourse(){




        return true;
    }
    // Method to update a course


    // Method to search course by code
    public boolean searchCourseByCourseCode(Course course){
        boolean found = false;
        for (int i = 0; i < enrolledCourses; i++){
            if(courses[i].getCourseCode().contains(course.getCourseCode())){
                courses[i].displayInfo();
                System.out.println("--------------------------------------");
                found = true;
            }
        }

        if (!found){
            System.out.println("Student: "+ Arrays.toString(courses) + " not found");
        }
        return false;
    }

    //Method to assign course to lecturer



    //Method to display all existing courses
    public void displayAllCourses(Course course){
        for (int i =0; i < enrolledCourses; i++){
            courses[i].displayInfo();
        }
    }

    // Method to filter by lecturer


    // check if course is for which type of student


    // Method to display course information




}

// ==============================================
// MAIN UNIVERSITY CLASS
// ==============================================

class University{

    public static final int MAX_UNI_STUDENTS = 1000;
    public static final int MAX_UNI_LECTURERS = 100;
    private Student [] students;
    private Lecturer [] lecturers;
    private int enrolledUniLecturers;
    private int enrolledUniStudents;
    private Course courses [];


    // Constructors
    public University(Student students, int enrolledUniLecturers, int enrolledStudentCount, Lecturer lecturers){
        this.enrolledUniStudents = 0;
        this.enrolledUniLecturers = 0;
        this.students = new Student[MAX_UNI_STUDENTS];
        this.lecturers = new Lecturer[MAX_UNI_LECTURERS];
    }
    //getters and setters
    public int getEnrolledUniLecturer(){
        return enrolledUniLecturers;
    }
    public void setEnrolledUniLecturer(int enrolledUniLecturer){
        this.enrolledUniLecturers = enrolledUniLecturer;
    }
    public int getEnrolledUniStudents(){
        return enrolledUniStudents;
    }
    public void setEnrolledUniStudent(int enrolledUniStudents){
        this.enrolledUniStudents = enrolledUniStudents;
    }


    // Method to check if limit reached student and if there is a duplicate
    public boolean canEnrollUniStudent(Student student ){

        for (int i =0; i< enrolledUniStudents; i++){
            if(students[i].getID().equals(student.getID())){
                System.out.println("Student " + student.getID() + student.getName());
                System.out.println("Duplicate student ID cannot print the student");
            }
        }

        if(enrolledUniStudents == MAX_UNI_STUDENTS){
            System.out.println("The university is full can't enroll more students!");
            return false;
        }
        System.out.println("Can enroll more students.");
        return true;
    }

    // Method to add student
    public boolean addUniStudent(Student student){
        if(canEnrollUniStudent(student)){
            students[enrolledUniStudents] = student;
            enrolledUniStudents++;
        }

        System.out.println("Congratulations, student Added Successfully!");

        return true;
    }

    // Check if we can enroll a lecturer
    public boolean canEnrollLecturer(Lecturer lecturer){
        // Check for duplicate lecturer ID
        for (int i = 0; i < enrolledUniLecturers; i++){
            if(lecturers[i].getID().equals(lecturer.getID())){
                System.out.println("Lecturer: " + lecturer.getID() + lecturer.getName());
                System.out.println("Duplicate lecturer ID cannot enroll the lecturer");
            }
        }
        // Enroll the lecturer
        if (enrolledUniLecturers == MAX_UNI_LECTURERS){
            System.out.println("Lecturers slot full, can't enroll more!");
            return false;
        }
        System.out.println("Can enroll Lecturer!");
        return true;
    }

    // Method to enroll a lecturer
    public void addLecturer(Lecturer lecturer){
        if(canEnrollLecturer(lecturer)){
            lecturers[enrolledUniLecturers] = lecturer;
            enrolledUniLecturers ++;
            System.out.println("Lecture enrolled to the university!");
        }
        System.out.println("Lecturer not enrolled! Try again.");
    }

    // Method to display all students
    public void displayAllStudents(){
        if (enrolledUniStudents == 0){
            System.out.println("No students enrolled!");
        }

        for (int i = 0; i < enrolledUniStudents ;i++){
            System.out.println((i + 1) + " ." );
        }

    }

    // Method to display all courses
    // Call the method from the CourseManager class.

    // Method to search student by ID
    public boolean searchStudentByID(Student student){
        boolean found = false;
        for (int i = 0; i < enrolledUniStudents; i++){
            if(students[i].getID().contains(student.getID())){
                students[i].displayInfo();
                System.out.println("--------------------------------------");
                found = true;
            }
        }

        if (!found){
            System.out.println("Student: "+  student + " not found");
        }
        return false;
    }

    // Method to search student by their names
    public boolean searchStudentByName(Student student){
        boolean found = false;
        for (int i = 0; i < enrolledUniStudents; i++){
            if(students[i].getName().contains(student.getName())){
                students[i].displayInfo();
                System.out.println("--------------------------------------");
                found = true;
            }
        }

        if (!found){
            System.out.println("Student: "+  student + " not found");
        }
        return false;
    }


    // Method to display University info
    public void displayInfo(){
        System.out.println("=====================================================================================");
        System.out.println("=====================" + " JOMO KENYATTA UNIVERSITY "+ "=============================");
        System.out.println("=====================================================================================");
        System.out.println("Total University Students: " + enrolledUniStudents);
        System.out.println("Total University Lecturers: " + enrolledUniLecturers);


    }
}
public class StudentManagementSystem {

    public static void main(String[] args) {

    }
}
