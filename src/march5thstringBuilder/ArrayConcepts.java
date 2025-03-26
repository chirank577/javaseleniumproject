package march5thstringBuilder;


import java.util.Arrays;

public class ArrayConcepts {

    public static void main(String[] args) {

        //Arrays is nothing but collection of homogenous set of data

        //Types of Array:
        //1. 1D Array
        //2. 2D Array
        //3. 3D Array

        //Syntax of creating an array:
        //datatype[] arrayName=new datatype[size of the array];

        //Here we need to maintain the size of the array upfront because it needs
        //to know how much memory should be allocated in the heap

        int[] a4=new int[5];

        //Prints the size of the array
        System.out.println(a4.length);

        //[I@6acbcfc0
        //[I --> Represents an Integer Array
        //@6acbcfc0 --> Represents the hashcode of the array(Exact Memory Location in the heap)
        System.out.println(a4);

        //Prints the array in an understandable format
        System.out.println(Arrays.toString(a4));

        //Filling the complete array with value as 50
        Arrays.fill(a4,50);

        System.out.println(Arrays.toString(a4));

        //Copying the array a4 into another array whose size of the array is 10
        int[] b4=Arrays.copyOf(a4,10);

        System.out.println(Arrays.toString(b4));

        //Filling the array from 5th index position till the 10th index position with value as 20
        Arrays.fill(b4,5,10,20);

        System.out.println(Arrays.toString(b4));

        //Copying the values from 5th index position to 10th index position into another array
        //If the end index position that we pass is exceeding the length of the array, then the remaining values will be marked with the default value
        //If we pass a value in the start index position that is greater than the length of the array, then it will throw ArrayIndexOutOfBoundsException
        int c4[]=Arrays.copyOfRange(b4,5,15);

        System.out.println(Arrays.toString(c4));

        //Using the for loop to print the values in the array one by one:

        //Print the value that is present in the 3rd index position in the c4 array
        System.out.println(c4[3]);

        //Print the value that is present in the 1st index position in the c4 array
        System.out.println(c4[1]);

        System.out.println("****************************************************************");

        for(int i=0;i<c4.length;i++)
        {
            System.out.println(c4[i]);
        }



    }
}