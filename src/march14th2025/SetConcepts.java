package march14th2025;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetConcepts {



        public static void main(String[] args) {

            //Set:
            //1. It is an interface
            //2. It does not allow duplicate values
            //3. It does not maintain insertion order (Data will be stored in a random order)
            //4. It is implemented in HashSet, LinkedHashSet, TreeSet
            //5. It allows null values

            //Syntax of creating a set:
            //Set<DataType> setName=new HashSet<DataType>();

            Set<Integer> s2=new HashSet<Integer>();

            s2.add(10);
            s2.add(-49);
            s2.add(49);
            s2.add(10);
            s2.add(null);
            s2.add(39205);

            System.out.println(s2);

            System.out.println(s2.isEmpty());

            System.out.println(s2.size());

            System.out.println(s2.contains(4924));
            System.out.println(s2.contains(49));

            s2.remove(10);

            System.out.println(s2);

            //Converting the set into an array
            Integer[] i1=s2.toArray(new Integer[s2.size()]);
            System.out.println(Arrays.toString(i1));

            s2.clear();

            System.out.println(s2.isEmpty());

            Set<Integer> s3=new HashSet<Integer>();

            s3.add(10);
            s3.add(20);
            s3.add(30);
            s3.add(40);
            s3.add(50);

            //Combines the data that is present in both the sets snd stores in s2
            s2.addAll(s3);

            System.out.println(s2);

            //Retains the common data that is present in both the sets and stores in s2
            s2.retainAll(s3);

            System.out.println(s2);

            //Removes the common data that is present in both the sets and stores in s2
            s2.removeAll(s3);

            System.out.println(s2);

            //Iterate the data over the set:
            //For Each loop to iterate the data over the set
            for(Integer i2:s3) //for(int i=0;i<s3.size();i++)
            {
                System.out.println(i2);
            }

            //Create a Heterogeneous set:
            HashSet h2=new HashSet();

            h2.add(10);
            h2.add("Hello");
            h2.add(20.5);
            h2.add('A');
            h2.add(true);

            System.out.println(h2);
        }
}
