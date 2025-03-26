package march18th2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcepts {
    public static void main(String[] args) {
        //streams has started from jdk 1.8
        //performing operations on a large set of data
        //quick processing of data across the large set

        //Stream API is a way to express and process collections of objects.
        //a stream in java is a sequence of objects that supports various methods that can be pipelined to produce the desired result.
        //Enable us to perform operations like filtering, mapping, reducing, and sorting.

        List <String> l1=new ArrayList<>();

        l1.add("egg");
        l1.add("bread");
        l1.add("salt");
        l1.add("peppers");
        l1.add("sausage");

        //convert a list to stream:
        Stream<String> s1=l1.stream();//converting the list to a stream of data

        //.foreach() is used to print the data that is present in the stream
        //.foreach() is a terminal operation(After this function we cannot chain this with any other operations)
        //.foreach () accepts a consumer interface ( As a loop, it consumes each and every value from the stream and process the data as per the given requirement

        s1.forEach((i)-> System.out.println(i));
        //********************************DO NOt REUSE THE STERAM OBJECTS IN THE FURTHER OPERATION*******************************************************************//
        //It is bcz the steram is a one time use object and the once the data is processed in the stream it won't work again


        //.filter() is used to get the data as per the given condition
        //.filter() is an intermediate operation( After this function we can chain this with any other operations)
        //.filter() accepts a predicate interface(It checks the condition and returns the data that satisfies the given condition)

        l1.stream().filter(s->s.length()>4.).forEach(System.out::println);//both works same
        l1.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));

        System.out.println("**********************************************************************************");

        //.map() is used to transform the data as per the given condition
        //.map() is an intermediate operation (After this function we can chain this with any other operation)
        //.map() accepts a function interface(It performs the logic based on the conditions that we provide)

        l1.stream().map(s -> s.toUpperCase()).forEach(s-> System.out.println(s));

        System.out.println("************************************************************************");

        l1.stream().map(s->s.substring(0,3)).forEach(s-> System.out.println(s));

        System.out.println("************************************************************************");
        //sort the data in the list in ascending order
        //.sorted () is used to sort the data in the list
        //.sorted() is an intermediate operation(after this function we can chain this with any other operations)

        l1.stream().sorted().forEach(s-> System.out.println(s));

        System.out.println("*************************************************************************");

        //.skip () is ued to skip the data in the list
        //.skip is an intermediate operation(After this function we can chain this with any other operations)
        l1.stream().skip(2).forEach(s-> System.out.println(s));

        System.out.println("*************************************************************************");

        //.limit() is used to limit the data in the list works opposite to skip
        //.limit () is an intermediate operation(After this function we can chain this with any other operations)

        l1.stream().limit(3).forEach(s-> System.out.println(s));

        System.out.println("*************************************************************************");

        //convert the list to set:

        //.collect(0 is used to convert the seam to any other collection or any other data type
        //.collect() is a supplier interface (It supplies the data to the given collection or data type)
        //.collect() can act as a terminal operation(After this function we can not chain this with any other operations)
        //or an intermediate operator (After this function we can chain this with any other operations)

        Set<String> s4=l1.stream().collect(Collectors.toSet());
        System.out.println(s4);

        System.out.println("***************************************************************************");

        //convert the list into a comma-separated string
        //collector.joining(",") is used to join the data wuth "," in the form of a string
        String data=l1.stream().collect(Collectors.joining(","));
        System.out.println(data);

        System.out.println("***************************************************************************");
        //convert the list into a list of integers

        l1.stream().map(s->s.length()).forEach(s-> System.out.println(s));//it will print into a row
        List<Integer> dataLength=l1.stream().map(s->s.length()).collect(Collectors.toList());
        System.out.println(dataLength);

        System.out.println("***************************************************************************");

        //converting the list into a map where we have the data as the key and the length of the data as the value:

       // Map<String,Integer> m2= l1.stream().collect(Collectors.toMap((s)->s,(s)->s.length())).forEach((k,v)-> System.out.println(k+" : "+v));
        Map<String,Integer> m2= l1.stream().collect(Collectors.toMap((s)->s,(s)->s.length()));
        System.out.println(m2);
        System.out.println("***************************************************************************");
        //.allMatch() is an terminal operation(After this function we cannot chain this with any other operations)
        //.allMatch retrus the value as a boolean
        //.allMatch accepts  predicate interface (It checks the condition and returns the boolean value)
        //.allMatch will check whether the complete data is satisfying the given condition or not

        System.out.println(l1.stream().allMatch(s->s.length()>2));

        System.out.println("***************************************************************************");
        //Checking wether the given condition is satisfying for any of the data in the list or not
        //.anyMatch() is an terminal operation(After this function we cannot chain this with any other operations)
        //.anyMatch () returns the value as a boolean
        //.anyMatch() accepts  predicate interface (It checks the condition and returns the boolean value)
        //.anyMatch() will check whether the complete data is satisfying or any of the data in the list or not
        System.out.println(l1.stream().anyMatch(s->s.length()>3));


        System.out.println("***************************************************************************");
        //Checking whether the given condition is not satisfying for any of the data in the list or not
        //.noneMatch() is an terminal operation(After this function we cannot chain this with any other operations)
        //.noneMatch () returns the value as a boolean
        //.noneMatch() accepts  predicate interface (It checks the condition and returns the boolean value)
        //.noneMatch() will check whether the complete data is satisfying or any of the data in the list or not

        System.out.println(l1.stream().noneMatch(s->s.length()>7));













    }
}
