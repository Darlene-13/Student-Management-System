package io.github.darlene;
import java.util.*;
import java.util.UUID;


// Making the abstract class public because it is being used across different classes and file// This is a java best praactice.
abstract class Person{

    private String name;  // What if this method is null? or empty? or just spaces?
    private int age;
    private String email;
    private final String id; // Make ID final so that it cannot be changes by anyone

    // Constructor for the abstract class
    public Person(String name,int age, String email, String id){
        // this.name = name; this constructor alone will throw a null pointer exception
        //Check if name is null and empty
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null and empty");
        }

        // this.age = age; we also have to validate age so that no one puts a negative age, and it should all be above 18 years only.
        if(age < 18 || age > 75){
            throw new IllegalArgumentException("Invalid age! Should be between 18 and 75");
        }

        // this.email = email; the email input should also be validated in case of null pointers and empty spaces.
        // Check for null , spaces and if it does not contain @ and throw new IllegalArgumentException
        if(email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Email cannot be empty and should have the @ element.");
        }

        this.name = name;
        this.age = age;
        this.email = email;
        this.id = UUID.randomUUID().toString();
    }

    // GETTERS AND SETTERS
    public String getName(){
        return name;
    }
    public void setName(String name){
        // Check for null pointer
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Null and Empty Pointer Exception");
        }
        // set the name
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        // Validate age before accepting age.
        // this.age = age; we also have to validate age so that no one puts a negatibve age and it should all be above 18 years only.
        if(age < 18 || age > 75){
            throw new IllegalArgumentException("Age should be between 18 and 75");
        }
        this.age = age;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        // Validate email too....Prevent crashes: If you later do email.contains("@") and email is null → NullPointerException
        // this.email = email; the email input should also be validate incase of null pointers and empty spaces.
        // Check for null and throw new IllegalArgumentException
        if(email == null || email.trim().isEmpty() || !email.contains("@")){
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }
    public String getId(){
        return id;
    }

    // NOTE: LOOOK AT OVERRIDING THE HASHMETHOD.
    // Overriding the default toString method this is important to make our output human-readable.
    @Override
    public String toString(){
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    // Overriding the default .equals() in the case where there might be two students with same parameters but are actually different people
    @Override
    public boolean equals(Object obj) {
        if (this == obj)return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id.equals(person.id);
    }
    // CONSIDER ADDING THE HASHCODE OVERRIDE.

    // Abstract method to be implemented by subclass
    public abstract void displayInfo();
}




// ==============================================
// STUDENT CLASS
// ==============================================

// Using Arrays.copyOf does not create a new array but references the existing array.
enum StudentType {
    UNDERGRADUATE,
    GRADUATE,
    PHD
}

class Student extends Person{

    private String [] grades;
    private List<Course> courses;
    private StudentType studentType;
    private int studentCourseCount;
    private final static int MAXIMUM_COURSE_ENROLLED = 5;


    // Constructors for the students class
    public Student(String name, int age, String email, String id, String [] grades, List<Course> courses, StudentType studentType, int studentCourseCount){
        super( name, age, email, id);
        // Prevent null pointer in grades by initializing empty arrays,using new String[0] initializes an empty array
        this.grades = (grades == null) ? new String[0] : Arrays.copyOf(grades, grades.length);
        if (courses == null){
            this.courses = new ArrayList<>();
        } else {
            this.courses = new ArrayList<>(courses);
        }

        if (studentType == null){
            throw new IllegalArgumentException("Student type cannot be null");
        }
        this.studentType = studentType;
        this.studentCourseCount = studentCourseCount;
    }

    // Getters and setters
    public String [] getGrades(){
        return grades;
    }
    public void setGrades(String[] grades){
        if (grades == null){
            this.grades = new String[0];
        } else {
            this.grades = Arrays.copyOf(grades, grades.length);
        }
    }
    public List<Course> getCourses(){
        return new ArrayList<>(courses); // return a copy
    }
    public void setCourses(List<Course> courses){
        if (courses == null) {
            this.courses = new ArrayList<>();
        } else {
            this.courses = new ArrayList<>(courses);
        }
    }
    public StudentType getStudentType(){
        return studentType;
    }
    public void setStudentType(StudentType studentType){
        if (studentType == null){
            throw new IllegalArgumentException("Student type cannot be null");
        }
        this.studentType = studentType;
    }


    // Method to enroll in a course
    public boolean requestEnrollCourse(Course course){
        // Checks if the course is available using the isAvailable method in CourseManager
        if(!CourseManager.isAvailable(course)){
            System.out.println("Course does not exist");
            return false;
        }
        if (course.canEnrollStudent(this)){ // Changed from Course.can enroll to course.can enroll meaning every course should have its own limit
            System.out.println("Student can be enrolled!"); // Grants the student permission to enroll....from the course....
            return true;
        }
        return true;
    }

    // Method to add course
    public void addCourse(Course course){
        if(courses.size() >= MAXIMUM_COURSE_ENROLLED){
            System.out.println("Course limit reached"); // Maximum limit of courses a student can enroll
            return;
        }
         if (courses.contains(course)){
             System.out.println("You have already enrolled in this course");
             return;
         }
         courses.add(course);
         studentCourseCount++;

    }

    // Method to remove a course or drop a course
    public void removeCourse(Course course){
        if (courses.isEmpty()){
            System.out.println("You have not enrolled in any courses");
            return;
        }
        if (!courses.contains(course)){   // this is the correct syntax and not course.equals(course.getCourseName or code...
            System.out.println("You are not enrolled in this course");
            return;
        }
        courses.remove(course);
        studentCourseCount--;
    }

    // Method to add grade after lecturer assigns
    public void addGrade(){

    }
    // Method to calculate GPA
    public String calculateGPA(){


        return "";
    }

    @Override
    public void displayInfo() {
        System.out.println("Name" + getName());
        System.out.println("Age" + getAge());
        System.out.println("ID" + getId());
        System.out.println("ID" + getId());
        System.out.println("Courses Enrolled" + courses);

    }
}


// At enterprise level this could later be changed to something like
/*
* class GradingPolicy {
*   private double aMin, bMin, cMin, dMin;
*
*   public GradingPolicy(double aMin, double bMin.............
*
*
*   public Grade getGrade(double.........// Have them getters for the grades
*
* }
* */

/*Grade
class Grade {
    private String letter;
    private double minScore;
    private double gpaValue;

    // Constructor
    public Grade(String letter, double minScore, double gpaValue) {
        this.letter = letter;
        this.minScore = minScore;
        this.gpaValue = gpaValue;
    }
    // Getters
    public String getLetter() {return letter;}
    public double getMinScore() {return minScore;}
    public double getGpaValue() {return gpaValue;}

    // Method to find grade from score
    public static Grade findGrade(double score){
        for(Grade g: GRADE_SCALE){
            if (score >= g.minScore) return g;
        }
        return new Grade ("F", 0, 0);
    }

    private static final List<Grade> GRADE_SCALE = List.of(
            new Grade("A", 90, 4.0),
            new Grade("A-", 85, 3.7),
            new Grade("B+", 80, 3.3),
            new Grade("B", 75, 3.0),
            new Grade("B-", 70, 2.7),
            new Grade("C+", 65, 2.3),
            new Grade("C", 60, 2.0),
            new Grade("D", 50, 1.0),
            new Grade("A", 0, 0)
    );
}
*/



enum Grade {
    A(90, 4.0),
    A_MINUS(85, 3.7),
    B_PLUS(80, 3.3),
    B(75, 3.0),
    B_MINUS(70, 2.7),
    C_PLUS(65, 2.3),
    C(60, 2.0),
    D(55, 1.0),
    F(0,0.0);

    // Declaring the two variables in the grade
    private final double minScore;
    private final double gpaValue;

    // Initializing the variables in the constructor
    Grade(double minScore, double gpaValue){
        this.minScore = minScore;
        this.gpaValue = gpaValue;
    }

    //Getters for the variables
    public double getGpaValue(){
        return gpaValue;
    }

    // Method to assign grade..
    public static Grade fromScore(double score){
        for (Grade g: values()){  // Looping through grades...
            if (score >= g.minScore) return g;
        }
        return F;
    }
}



// This class has lecturers who own the lessons or courses they teach.
// ==============================================
// LECTURER (TEACHER) CLASS
// ==============================================
class Lecturer extends Person{
    private double salary;
    private List<Course> courses;
    private static int COURSES_LIMIT = 5;
    private int courseCount;


    // Constructor for the Lecturer class
    public Lecturer(String name,int age,String email, String Id, double salary, List<Course> courses, int COURSES_LIMIT, int courseCount){
        super(name, age,email, Id);
        this.salary = salary;
        if (courses == null){
            this.courses = new ArrayList<>();
        } else{
            this.courses = new ArrayList<>(courses);
        }
        Lecturer.COURSES_LIMIT = COURSES_LIMIT;
        this.courseCount = courseCount;
    }

    // Getters and setters
    public double getSalary(){
        return salary;
    }
    public void setSalary(){
        this.salary = salary;
    }
    public List<Course> getCourses(){
        return new ArrayList<>(courses);
    }
    public void setCourses(List<Course> courses){
        if (courses == null){
            this.courses = new ArrayList<>();
        } else {
            this.courses = new ArrayList<>(courses);
        }
    }

    // Method to assign Grade
    public boolean assignGrade(Student student, Grade grade){
        // Check if the student has the course

        // Assign grade based on the mark.
        return true;
    }

    // Method to ask to be assigned a course to teach
    public boolean canTeachCourse(Course course){
        // Check if they have reached their course limit
        if(courseCount == COURSES_LIMIT){
            System.out.println("Courses Limit per lecturer reached!");
            return false;
        }
        // Check if they have a duplicate course
        for (int i=0; i<courseCount; i++){
            if(courses.get(i).getCourseCode().equals(course.getCourseCode())){
                System.out.println("Duplicate course found.");
                return false;
            }
        }
        // Check if the course is available
        if(!CourseManager.isAvailable(course)){
            System.out.println("Course not available");
        }

        if (course.canEnrollLecturer(this)){  // Passed "this" parameter since it needs to check the lecturer parameter which is actually the current class the this class.s
            System.out.println("Lecturer can enroll lecturer");
        }
        System.out.println("Lecturer can enroll lecturer");
        // Add courses to their list
        courses.add(course);
        courseCount++;
        return true;
    }
    // Method to set the desired salary
    public String desiredSalary(){

        return "";
    }

    // Method to display all info...Overrides the person abstract
    @Override
    public void displayInfo(){
        System.out.println("Name" + getName());
        System.out.println("Age" + getAge());
        System.out.println("ID" + getId());
        System.out.println("ID" + getId());
    }
}


// This class own the teaches who teaches the various courses..
// This class has students list so that we can know the maximum that shouldn't exceed a course.
class Course {
    private final String courseName;
    private final String courseCode;
    private List<Student> enrolledStudents;
    private List<Lecturer> lecturers; // Plural since it carries more than 1 lecturer.
    private final int maxLecturers ;
    private final int  maxStudents;
    // private int courseCount;   Removing this because it does not make sense inside one course object.


    // Constructors
    public Course(List<Student> enrolledStudents, String courseName, String courseCode, List<Lecturer> lecturer, int maxLecturers, int maxStudents){
        if (enrolledStudents == null){
            this.enrolledStudents = new ArrayList<>();
        } else{
            this.enrolledStudents = new ArrayList<>(enrolledStudents);
        }
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.maxStudents = maxStudents;
        this.maxLecturers = maxLecturers;
        if (lecturer == null){
            this.lecturers = new ArrayList<>();
        } else {
            this.lecturers = new ArrayList<>(lecturer);
        }
    }

    // Getters
    public String getCourseName(){
        return courseName;
    }
    public String getCourseCode(){
        return courseCode;
    }
    public List<Lecturer> getLecturer(){
        return new ArrayList<>(lecturers);
    }

    public void setLecturer(List<Lecturer> lecturer){
        if(lecturer == null){
            this.lecturers = new ArrayList<>();
        } else{
            this.lecturers = new ArrayList<>(lecturer);
        }
    }


    //Check if it can enroll student in course
    public boolean canEnrollStudent(Student student){
        if(enrolledStudents.size() >= maxStudents){
            System.out.println("Course is full, can't add more students");
            return false;
        }
        // Check if the student already exists
        if(enrolledStudents.contains(student)){
            System.out.println("Student already enrolled");
            return false;
        }
        System.out.println("Can enroll student.");
        return true;
    }

    //Check if it can enroll lecturer
    public boolean canEnrollLecturer(Lecturer lecturer){
        if(lecturers.size() >= maxStudents){
            System.out.println("Course is full, can't add more students");
            return false;
        }
        if(lecturers.contains(lecturer)){
            System.out.println("Lecturer already enrolled");
        }
        System.out.println("Can enroll Lecturer");
        return true;
    }

    // Method to filter a course by lecturer's name
    public boolean searchCourseByLecturerName(Lecturer lecturer){
        boolean found = false;
        for (int i = 0; i < lecturers.size(); i++){
            if(lecturers.get(i).getName().contains(lecturer.getName())){
                lecturers.get(i).displayInfo();
                System.out.println("--------------------------------------");
                found = true;
            }
        }
        if (!found){
            System.out.println("Lecturer: "+  lecturer.getName() + " not found");
        }
        return false;
    }

    // Method to filter by lecturer's ID
    public boolean searchCourseByLecturerCode(Lecturer lecturer){
        boolean found = false;
        for (int i = 0; i < lecturers.size(); i++){
            if(lecturers.get(i).getId().contains(lecturer.getId())){
                lecturers.get(i).displayInfo();
                System.out.println("--------------------------------------");
                found = true;
            }
        }

        if (!found){
            System.out.println("Lecturer " + lecturer.getName()  + " not found");
        }
        return false;
    }


    public void displayInfo(){
        System.out.println("=========================================================");
        System.out.println("===================" +  ("Get the Course Statistics") + "===================================");
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Course Code: " + getCourseCode());
        System.out.println("Number of students enrolled: " + enrolledStudents.size());

    }
}


// ==============================================
// COURSE MANAGER CLASS
// ==============================================

// Only manages anything to do with the course, not the student not the lecturer
class CourseManager {
    private static final List<Course> courses = new ArrayList<>();
    private static int enrolledCourses;
    public static final int MAX_COURSES = 50;
    private boolean isAvailable;

    // Constructors for the course class
    public CourseManager (int enrolledCourses, boolean isAvailable){
        CourseManager.enrolledCourses = 0;
        this.isAvailable = false;
    }

    // Getters and Setters
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Check if the course is available
    public static boolean isAvailable(Course course){
        return courses.contains(course);
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
        if (isAvailable(course) && canEnrollCourse(course)){
            System.out.println("Can not add a course");
        }

        System.out.println("Enrolling the new course to our system.............");
        courses.add(course);
        enrolledCourses++;
        System.out.println("Success course Added.");
        return true;
    }

    // Method to remove a course // After removing we will have to go a string back in the array..
    public boolean removeCourse(Course course){
        // Find the course in enrolled courses
        if(isAvailable(course)){
            System.out.println("Found the course, ready to remove it.");
        }
        courses.remove(course);
        enrolledCourses--;
        return true;
    }

    // Method to update a course
    public boolean updateCourse(Course courseName, Course courseCode){
        // Check if the course exists by course code
        if(isAvailable(courseName) && isAvailable(courseCode)){
            System.out.println("Course is available you can update it");
            return true;
        }



        return false;
    }

    // Method to search course by code
    public boolean searchCourseByCourseCode(Course course){
        boolean found = false;
        for (int i = 0; i < enrolledCourses; i++){
            if(courses.get(i).getCourseCode().contains(course.getCourseCode())){
                courses.get(i).displayInfo();
                System.out.println("--------------------------------------");
                found = true;
            }
        }

        if (!found){
            System.out.println("Course: "+ course.getCourseCode() + " not found");
        }
        return false;
    }


    //Method to display all existing courses
    public void displayAllCourses(Course course){
        for (int i =0; i < enrolledCourses; i++){
            courses.get(i).displayInfo();
        }
    }

    // Method to display university course information
    public void displayInfo(){
        System.out.println("Enrolled courses: " + enrolledCourses);
        System.out.println("Existing courses list: " );
    }
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
            if(students[i].getId().equals(student.getId())){
                System.out.println("Student " + student.getId() + student.getName());
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
            if(lecturers[i].getId().equals(lecturer.getId())){
                System.out.println("Lecturer: " + lecturer.getId() + lecturer.getName());
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
            if(students[i].getId().contains(student.getId())){
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
