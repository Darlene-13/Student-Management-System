# MAPPING IN JAVA

>In java, the map interface is part of the `java.util.package` and it basically represents a collection of key value pairs where:
> 
> - No duplicate keys are allowed therefore the keys should be unique.
> - Both HashMap and LinkedHashMap allow only one null key while the Tree Mao does not allow null keys at all.
> -  The use of ConcurrentHashMap for thread-safe operations ensures safe threading alternatives and by wrapping an existing map using Collections.synchronizedMap() for synchronized access.
> 
>  Unlike List or Array, a Map allowes one to directly access a value by the name, ID or any key chosen without looping.

#### Example:

``` import java.util.HashMap;
import java.util.Map;
public class Geeks {
    public static void main(String [] args){
        // Create a Map Using HashMap
        Map<String Integer> m = new HashMap<>();
        
        // Adding key value pairs to the map
        m.put("Geek1",1);
        m.put("Geek2",2);
        m.put("Geek3",3);
        
        System.out.println("Map elements: " + m);
    }
} 

```

#### HIERARCHY OF THE MAP ....THE MAP DATA STRUCTURE
The Map data structure can be implemented by two interfaces in java the: 1. Map Interface. 2. SortedMap Interface.

The three primary classes that implement these interfaces are:
1. HashMap
2. TreeMap
3. LinkedHashMap

#### CREATING MAP OBJECTS
Since MAP is an interface, objects can not be created for the type map. We always need a class that impelements this map interface in order to create an object and also currently is is possible to restrict the type of object that can be stored in  map.

##### Example

```aiignore
import java.util.*;

class MapObjects{
    public static void main(String[] args){
    
    Map<String Integer> hm = new HashMap<String Integer>();
    
    hm.put(("A", new Interger(100));
    hm.put(("B", new Interger(200));
    hm.put(("C", new Interger(300));
    hm.put(("D", new Interger(400));
    
    
    for(Map.Entry<String Integer> me:
        hm.entrySet()){
        System.out.println(me.getKey() + ":");
        System.out.println(me.getValue());
        }
    }
}
```

#### IMPLEMENTED CLASSES OF THE MAP INTERFACE
1. HashMap: 

A HashMap is a part of Java's collection framework and implements the Map Interface. It stores elements in key value pair.

The capacity of a hasMap is the numbr of buckets it can hold for storing entries.
- new capacity = old capacity x 2

HashMap declaration is done like this.

```aiignore
public class HashMap<K, V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable,

```

- It basically takes two parameters:
- 1. The type of keys maintained in the map.
- 2. The type of mapped values

A HashMap in java implements Serializable, Cloneable, Map<K,V> interfaces and it extends the AbstractMap<K,V> class.