package march17th2025;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapConcepts {
    public static void main(String[] args) {
        //Map: it is an interface
        //it accepts the data in the form of key value pairs
        //data will be stored in random order
        //each key value pair is known as an entery
        //Duplicate keys are not allowed, but duplicate value are allowed
        //It is being implemented in LinkedHashMap, HashMap, TreeMap

        //Syntax of creating a map:
        //Map<keyDataType, ValueDataType> mapname=new Hashmap< Keydatatype, Vvaluedata type();

        Map<String,Integer> m1=new HashMap<>();

        m1.put("chiru",29);
        m1.put("gupta",28);
        m1.put("ankit",31);
        m1.put("SHiva",32);

        System.out.println(m1);
        m1.put(null,null);
        m1.put("indu",32);
        System.out.println(m1);

        m1.put("indu",45);//if key is already present then it overrides the value
// print how many enteries present in the map
        System.out.println(m1.size());

        System.out.println(m1.isEmpty());

        //checks if the key is present in the given map
        //returns true if the key is present in the map else returns false
        System.out.println(m1.containsKey("chiru"));
        System.out.println(m1.containsValue("29"));

        //prints the list of keys present in the map
        System.out.println(m1.keySet());
        //prints the list of value present in the map
        System.out.println(m1.values());

        //prints the data that is present in the map in the form of entries
        System.out.println(m1.entrySet());

        //print the value that is present againt the key
        //if the geiven key is not available it will show null
        System.out.println(m1.get("chiru"));

        //if the given key is not available in the map, then it will print as -1
        System.out.println(m1.getOrDefault("what",-1));

        //adds the entry to the map, if the key is not present
        m1.putIfAbsent("jev",29);
        m1.putIfAbsent("chiru",29);//key chiru is already present in the map so it will not be added
        System.out.println(m1);

        //it removes the key and value
        m1.remove(null);
        System.out.println(m1);
        //removing the entery from the map, if both key and value are matching with the data that is present
        m1.remove("indu",45);//but is one of them is not matching it won't remove
        System.out.println(m1);

        m1.replace("gupta",34);//replacing the value of gupta

        m1.replace("jev",29,28);//replacing the value only when key value is matching
        System.out.println(m1);

        //replacing all the value in the map with the given lambda expression
        //it accepts a bifunction interface

        m1.replaceAll((k,v)->v*2);
        System.out.println(m1);

        //erases the complete data from the map
        m1.clear();

        System.out.println(m1);

        Map <String,Integer> m2=new HashMap<>();

        m2.put("two",4);
        m2.put("three",6);
        m2.put("four",8);
        m2.put("five",10);

        m1.putAll(m2);

        //.forEach accepts a BiConsumer interface
        //Because the foreach will consume each and every entry and perform the desired actions
        m1.forEach((key,value)-> System.out.println(key+"......"+value));

        //another way of iteracting the map:
        Set<Map.Entry<String,Integer>> m3=m1.entrySet();// converting the map into the set of entries
        for(Map.Entry<String,Integer>e1:m3)
        {
            System.out.println(e1.getKey()+"....."+ e1.getValue());//for(int 1=0; i<s2.size();i++
        }

        //creating unmodified map no one can change
        Map<String,Integer> m5=Map.of("six",6,"seven",7,"eight",8);

       // m5.replace("eight",9);//throws and error unsupported error

        System.out.println(m5);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //want to preserve the order of entries
        //linkedhashmap is slower than hashmap,linkedhashmap it needs time to preserve the data

        Map<String, Integer>l1=new LinkedHashMap<>();
        l1.put("nine",9);
        l1.put("ten",10);
        l1.put("eleven",11);

        System.out.println(l1);






    }
}
