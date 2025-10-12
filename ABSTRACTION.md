### STUDENT MANAGEMENT SYSTEM

##### This document is basically for learning purposes. 
##### ABSTRACTION
- There are two ways in which Abstraction can be achieved in Java, that is partially and fully.
- 1. Abstract class (This is partial abstraction)
- 2. Interfaces ( This achieves fully abstraction)

##### REAL LIFE EXAMPLE
- A real world example of this is the television remote control: It tends to simplify the interaction with a TV by hiding all the complex technology.
- We don't understand how the TV works internally we just need to press the button to change the channel


##### ABSTRACT CLASS
- An abstract class can't be instantiated, and it may contain abstract methods, this are methods without a  body as well as concrete methods which are methods without implementation.

##### PROGRAMMING EXAMPLE
```java
// Abstract class
abstract class Shape{
    String color;

    // Absract methods
    abstract double area();
    public abstract String toString();

    //Abstract class can have a contructor
    public Shape(String color){
        System.out.println("The shape constructor is callled");
        this.color = color;
    }
    // concerete method
    public string getColor(){
     return color;
     }
}

class Circle extends Shape{
    double radius;
    
    public circle(String color, double radius){
        // Calling the shape constructor
        super(color);
        System.out.println("Circle constructor is called");
        this.radidus = radius;
    }
    @Override double area(){
        return Math.PI * Math.pow(radius, 2);
    }
    @Override public String toString(){
        return "Circle color is " + siper.getColor() + " and the area is :" + area();
    }
}

class Rectangle extends Shape{
    double length;
    double width;
    
    public Rectange(String color, double length, double width){
        // calling the shape constructor
        super(color);
        System.out.printn("Rectange constrcutor is called");
        this.lenghth = length;
        this.width = width;
    }
    @Override double area(){
         return length * width;
    }
    @Override public String toString(){
        return "Rectangle color is " + super.getColor() + " and the area is :" + area();
    }
}

public class Main{
    public static void main(String[] args){
    shape s1 = new Circle("Red", 2.2);
    shape s2 = new Rectange("Yellow", 2, 4);
    
    System.out.println(s1.toString());
    System.out.println(s2.toString());
    }
}

```

##### INTERFACES
- Interfaces in hava is a blueprint of a class and can be used to achieve 100% abstraction.
- -It can contain abstract methods and constants but no method bodies except default and static methods.
- To implement an interface we use the key word (implements) with class while for abstraction we used extends.
- Interfaces only define behaviour and not the attributes 
- What is allowed in an interface?
  - Constants that is variables that are implicitly (public static final).
  - Abstract methods that are implicitly public abstract
  - Default methods that are defined with the default keyword
  - Static methods that are defined with the static keyword

````java
// Interface
interface Shape{

    // Abstract emthods for calculing area.
    double calculateArea();
}

// Implement the interface
class Circle implements Shape{
    private double radius;
    
    // Constructor for circle
    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    // Implementing the calculate area method
    public double calculateArea(){
        return Math.PI * Math.pow(radius, 2);
    }
}

// Implement the interface
class Rectangle implements Shape{
    double length;
    double width;
    
    // Constructor for rectange
    public Rectange (double length,double width){
        this.length = length;
        this.width = width;
    }
    
    // Getters and setters
    public double getLength(){
        return length;
    }
    public void setLength(double length){
        this.length = length;
    }
    
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    
    // Implementing the calculate area method
    public double calculateArea(){
        return length * width;
    }
    
}
public class Main {
    public static void main(String[] args){
     // Creating instances of circles and rectangles
     Circle c = new Circle(5.0);
     Rectange r = new Rectange(4.0, 6.0);
     
     System.out.println("Circle area: " + c.calculateArea());
     System.out.println("Rectangle area: " + r.calculateArea());
    
    }
}

````

##### DIFFERENCE BETWEEN ABSTRACT CLASS AND INTERFACE
| Abstract Class | Interface |
|----------------|-----------|
| Can have instance variables | Cannot have instance variables |
| Can have constructors | Cannot have constructors |
| Can have concrete methods | Cannot have concrete methods (except default and static methods) |
| Supports single inheritance | Supports multiple inheritance |
| Can have access modifiers for methods and variables | All methods are implicitly public |
| Can provide method implementations | Cannot provide method implementations (except default and static methods) |  
| Used when classes share a common base | Used to define a contract for unrelated classes |
| Can have any visibility: public, protected, private | All methods are implicitly public |
| Can have state (instance variables) | Cannot have state (only constants) |
| Can have final, non-final, static, and instance methods | All methods are implicitly abstract (except default and static methods) |
| Can extend only one class | Can implement multiple interfaces |


##### ADVANTAGES OF ABSTRACTION
- Reduces a programs complexity by hiding unnecessary details from the user
- It keeps different parts of the system separated
- It makes it easier to maintain and modify code
- It helps in achieving loose coupling between different parts of the system

##### DISADVANTAGES OF ABSTRACTION
- IT can add unnecessary complexity if not used properly
- May reduce flexibility in some cases
- It can lead to performance overhead due to additional layers of abstraction
- It may make debugging more difficult as the actual implementation is hidden


