UNIVERSITY STUDENT MANAGEMENT SYSTEM
> This is a CLI project for a University student Management System in Java, the project is meant to teach more on OOP in java.

#### OOP CONCEPTS COVERED
Abstraction: The project uses an abstract class Person that is being extended by the Lecturer and student class



### GRADES DEFINITION
Why did I choose to use enum instead of Grade for my project?
Here's why.

| Feature | `enum Grade` | `class Grade` |
|----------|---------------|---------------|
| **Purpose** | Fixed set of known constants | Flexible, can create any number dynamically |
| **Memory** | One shared instance per constant | New object for every instance |
| **Use case** | Perfect for fixed categories (A, B, C, D, F) | Needed when you might load grade scales dynamically (e.g., from DB or file) |
| **Performance** | Super fast — values are preloaded | Slightly slower, depends on object creation |
| **Readability** | Clean and clear — great for logic | More code, more flexibility |
| **Example usage** | `Grade.A_PLUS.getGpaValue()` | `new Grade("A+", 95, 4.0)` |

---

## 🧠 Summary

- Use **`enum`** when your grading scheme is *fixed* and universal (e.g., A–F).
- Use a **`Grade` class** when you want flexibility — for example, schools defining their own grading scales or loading them from a file.

N/B: If we want to add elements to out array it is important that we use ArrayList than bare Arrays, this is because an An Array has a fixed size and for us to add an element then that means that we need to create a copy for a new array
yet while using ArrayList<> for example here List<Course> courses and then using it in practice ArrayList <Course> = new ArrayList<> (courses);
