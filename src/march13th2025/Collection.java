package march13th2025;

import javax.sql.rowset.serial.SerialStruct;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Collection {
    public static void main(String[] args) {

        //collection is a framework in java that stores and manipulates a grou of objects
        //collection is an interface

        //List:
        //1. It is an interface
        //2. It allows duplicate values
        //3. it allows null values
        //4. It preserves the insertion order(fifo - first in first out)
        //5. It is index based
        //6. It is implimented in ArrayList, LinkedList, STack, vector

        //syntax of creating a list:
        //List<datatype> listname=new Arraylist <datatype>();

        List <String> l1=new ArrayList <String>();
        l1.add("name");
        l1.add("num");
        l1.add("what");
        l1.add(null);
        l1.add("yes");
        System.out.println(l1);

        //print the size of list
        System.out.println(l1.size());

        //check if the word "sample" is present in the list or not
        //Returns true if the above condition is satisfied else false
        System.out.println(l1.contains("name")||l1.contains("num"));

        System.out.println(l1.isEmpty());

        //gets the first value from the list
        System.out.println(l1.getFirst());

        //gets the last value from the list
        System.out.println(l1.getLast());

        //replacing the value that is present at the 5th index position
        l1.set(3,"chiru");
        System.out.println(l1);

        //prints the list in the reversed order
        System.out.println(l1.reversed());

        //adds the value at the start of  the list
        l1.addFirst("ankit");
        l1.addFirst("gupta");
        System.out.println(l1);

        //adds the value to the last
        l1.addLast("shiva");
        l1.addLast("ji");
        System.out.println(l1);

        //removes the value that is present at the 5th index position
        l1.remove(3);
        System.out.println(l1);

        try {
            l1.remove(300);
            System.out.println(l1);//outofindex execption error}

        }
        catch (IndexOutOfBoundsException e1)
        {
            System.out.println("Please check the size of the list");
        }

        l1.remove("ji");//removes the data based on value
        System.out.println(l1);

        l1.removeLast();
        System.out.println(l1);

        l1.removeFirst();
        System.out.println(l1);

        l1.add("chiru");
//prints the index of the first occurence of the word
        System.out.println(l1.indexOf("chiru"));
        System.out.println(l1);
        System.out.println(l1.lastIndexOf("chiru"));

        System.out.println(l1.indexOf("om"));// if value is not present the list it prints -1

        System.out.println(l1.get(4));//prints the value which is present in 4th index position

        l1.add(4,"no");//adding value on 4th index position
        System.out.println(l1);

        //l1.clear();// remove the complete set of data, returns empty list

        System.out.println(l1);

        System.out.println(l1.isEmpty());

        List<String> l2=new ArrayList<String>();
        l2.add("chiru");
        l2.add("ankit");
        l2.add("gupta");
        l2.add("shiva");

        l1.addAll(l2);

        System.out.println(l1);
        System.out.println(l2);
        l2.add("singh");
        l2.add("tejash");


        //retains the common values between l1 and l2 and stres in l1
        //Intersection operation
        l1.retainAll(l2);
        System.out.println(l1);

        //removes all the values of l2 that is present in l1
       l1.removeAll(l2);

        System.out.println(l1);
//removes the dtring from the list whose length is greater than 3
        l2.removeIf( s->s.length()>1);
        System.out.println(l2);

        ArrayList<Integer> i= new ArrayList<Integer>();
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);
        i.add(5);

        i.removeIf(n->n%2==0);
        System.out.println(i);

        for(int q = 0; q<i.size(); q++)
        {
            System.out.println(i.get(q));
        }

        for(int q:i)
        {
            System.out.println(q);
        }
        //Convert a list into an array
        String[] arr1=l2.toArray(new String[l2.size()]);
        System.out.println(Arrays.toString(arr1));

        //Object is the parent class of all the classes in Java
        Object[] o1=l2.toArray();
        System.out.println(Arrays.toString(o1));

        System.out.println("*********************************************************************************");

        //Unmodifiable List
        List<String> ul1=List.of("Sample","Data","NewMan","Whole","Sample");

        //Throws Unsupported Operation Error if we try to modify the data of the unmodifiable list
//        System.out.println(ul1.set(2,"New Data"));

        //Convert the array to a list:
        List<String> al1= Arrays.asList("Noco","Lara B","Dunker","James");

        al1.set(2,"New Data");

        System.out.println(al1);

        //Sorts the list in ascending order
        Collections.sort(al1);
        System.out.println(al1);

        //Shuffles the data in the list
        Collections.shuffle(al1);
        System.out.println(al1);

        //Swaps the data that is present at 1st index position with the data that is present at 3rd index position
        Collections.swap(al1,1,3);

        System.out.println(al1);









    }




}
