package march14th2025;


    import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

    public class LinkedHashSetConcepts {

        public static void main(String[] args) {

            //LinkedHashSet preserves the insertion order
            //Rest of the set attributes are same as HashSet

            Set<Double> s3=new LinkedHashSet<Double>();

            LinkedHashSet <Integer> s2=new LinkedHashSet<Integer>();

            s2.add(10);
            s2.add(-49);
            s2.add(49);
            s2.add(10);

            System.out.println(s2);

            s2.addFirst(100); //JDK 21 Function
            s2.addLast(200); //JDK 21 Function

            System.out.println(s2);

            s2.removeFirst(); //JDK 21 Function
            s2.removeLast(); //JDK 21 Function

            System.out.println(s2);

            System.out.println(s2.getFirst()); //Gets the first value from the set
            System.out.println(s2.getLast()); //Gets the last value from the set

            for(Integer i:s2)
            {
                System.out.println(i);
            }

            //Convert a set to a List:
            List<Integer> l1=new ArrayList<Integer>(s2);

            System.out.println(l1);

            l1.add(10);
            l1.add(49);

            System.out.println(l1);


        }

    }
