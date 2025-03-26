package march6th2025;

import java.util.Arrays;

public class TwoDimensionalArrays {

    public static void main(String[] args) {

        //Representing the data in a tabular format
        //Representing the data in the form of rows and columns

        //2D Array is nothing but array of arrays

        //Syntax of declaring a 2d array:
        //dataType[][] arrayName=new dataType[rows][columns];

        int a[][]=new int[2][2];

        //[[I@6acbcfc0
        //[[I --> Represents a 2D Array
        //@6acbcfc0 --> Represents the hashcode of the 2D Array(Exact memory location of the 2D Array in the heap)
        System.out.println(a);

        //.deepToString() is used to print a 2D array in a readable format
        System.out.println(Arrays.deepToString(a));

        //Arrays.fill will work only for 1D Arrays
//        Arrays.fill(a);

        //Prints the number of rows
        System.out.println(a.length);

        //Prints the number of columns
        System.out.println(a[0].length);

        for(int i=0;i<a.length;i++)
        {
            Arrays.fill(a[i],40);
        }

        System.out.println(Arrays.deepToString(a));


        //Copying the array into another 2d Array where the number of rows is 4
        //Here the number of columns remains the same
        int b[][]=Arrays.copyOf(a,4);

        System.out.println(Arrays.deepToString(b));

        //Running a loop around the 2d array:
        for(int i=0;i<b.length;i++)
        {
            if(b[i]==null) //Checking whether the given 1D Array is null or not
            {
                //If it is null, then create the 1D Array, based on the below program
                b[i]=new int[b[0].length];
            }
        }

        System.out.println(Arrays.deepToString(b));

        //Increasing the number of columns for each and every row
        for (int i=0;i<b.length;i++)
        {
            b[i]=Arrays.copyOf(b[i],4);
        }

        System.out.println(Arrays.deepToString(b));
    }
}

