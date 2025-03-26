package march7th2025;

import java.util.Arrays;

public class ArraysWithLambda {
    public static void main(String[] args) {

        int a[]={5,6,1,2,3,4,5,6};
        for(int i=0;i<a.length;i++)
        {
            a[i]*=a[i];
        }
        System.out.println(Arrays.toString(a));
// we are passing a labda expression here to indicate that
        //this is the logic we are writing for the intUnaryOperator
        //IntUnaryOperator helps us in modifying the values present inside the integer
        Arrays.setAll(a,i->a[i]*2);
        System.out.println(Arrays.toString(a)+" with lambda expression");

        //sort the data in ascending that is present in the array from 1st index position
        Arrays.sort(a,0,3);
        System.out.println(Arrays.toString(a));
        //.parallelsort() that is used to sort the array if size of the array is huge




    }
}
