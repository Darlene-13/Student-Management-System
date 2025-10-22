# MAPPING IN JAVA

>In java, the map interface is part of the `java.util.package` and it basically represents a collection of key value pairs where:
> 
> - No duplicate keys are allowed therefore the keys should be unique.
> - Both HashMap and LinkedHashMap allow only one null key while the Tree Mao does not allow null keys at all.
> -  The use of ConcurrentHashMap for thread-safe operations ensures safe threading alternatives and by wrapping an existing map using Collections.synchronizedMap() for synchronized access.
> 
> 

#### Example:

``` import java.util.HashMap;
import java.util.Map;
public class Geeks {
public static void main(String [] args){
    // Create a Map Using HashMap
    Map<String Integer> m = new HashMap<>();
    
    // Adding key value pairs to the map
    m.put("Geek1",1);






} 

```