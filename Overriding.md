### METHOD OVERRIDING
- Doing this project I learnt about (Overring) methods in java. 
- Overriding that is written as "@Overrding" is one of the key concepts of OOP in java.
- It covers the whole aspect of inheritance. 
- When a child class inherits a method from the parent class and it has to implement or extend new parameters then the method has to be overridden.
- I guess you'd be asking yourself by now why??

> Method Overriding allows the child class to have its own features different from the parents without overrding the parent method then the child class won't be able to implement its own features.
> 
> Additionally, we can also override Java built in methods like .equals() .hashCode() amongst others.
> 
>
### WHAT `hashCode()` REALLY IS:
> Every object in java has a method called `hashCode` which returns an integer (the hash code) basically a numeric fingerprint of the object.
> 
> That number is used by data structures like: {HashMap, HashSet and HashTable} to quickly locate or compare objects, we will definitely come to this.
>
> Think of a hashCode like a bucket number:
> 
>  - Java puts objects that seem similar based on their hash codes in the same bucket
>  - Then it compares them more deeply using equals() to confirm they truly are equal.
> So hashCode() in  java is used for speed, while equals() is used for accuracy.
> 
### THE RULE `hashCode()` CONTRACT
> There is a golden rule to be followed in Java when overriding equals() and hashCode().
>  - If two objects are equal according to equals(), they must return the same hashCode() value.
>  
> Picture this:
> - `Student s1 = new Student("Darlene", "22", "darlenewendie@gmail.com", "S001");`
> 
> - `Student s2 = new Student("Darlene", "22", "darlenewendie@gmail.com", "S002");`
> 
> Now suppose we add one to the:
> `HashSet<>() set = new HashSet<>();
> set.add(s1)`
> 
> Then if we check:
> `set.contains(s2)`
> 
> #### SCENARIO 1: We didn't override
>  `s1.hashCode()` and `s2.hashCode()` are different (since by default it’s based on memory address).
> 
> The set looks in the wrong bucket, doesn’t find s2, and returns false. ❌
Even though logically it’s the same student.
> 
> #### SCENARIO 2. We overrode `hashCode()` based on id
> Now both return the same hash code (because both have id = "S001").
> 
> The set checks the same bucket, finds s1, and confirms equality with equals().
> 
> 