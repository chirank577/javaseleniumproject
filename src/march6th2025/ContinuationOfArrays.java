package march6th2025;

import java.util.Arrays;

public class ContinuationOfArrays {


        public static void main(String[] args) {

            int a[]=new int[5];

            for(int i=0;i<a.length;i++)
            {
                a[i]=i*i-a.length;
            }

            System.out.println(Arrays.toString(a));

            //Another way of declaring the array
            //a[] = {-5,-4,-1,4,11}
            int[] b={-5,-4,0,4,11};

            //Compares both the arrays
            //Returns 0 if both the arrays are equal
            //Returns 1 if the first array is greater than second array
            //Returns -1 if the second array is greater than the first array
            System.out.println(Arrays.compare(a,b));

            //Prints the index position of the first mismatched value between both the arrays
            //If both the arrays are same then it will return -1
            System.out.println(Arrays.mismatch(a,b));

            int c[]=b;

            System.out.println(Arrays.mismatch(b,c));

            double[] d4={5.14,2.5,-5.2,4.215};

            //Sorts the data in the ascending order
            Arrays.sort(d4);

            System.out.println(Arrays.toString(d4));

            String[] s3={"Jack","Will","Norman","Powell"};

            //Before we do a binary search , we have to sort the array in Ascending order
            Arrays.sort(s3);

            //Prints the index position of the given value if it is present in the array
            //If it is not present then it will print a -ve value
            System.out.println(Arrays.binarySearch(s3,"Norman"));
            System.out.println(Arrays.binarySearch(s3,"Nor"));

            String k2="Shivani is attending the sessions";

            //Prints the number of words that is present in the string
            //k2.split(any character or any string) will return a String Array
            System.out.println(k2.split(" ").length);

            System.out.println(Arrays.toString(k2.split(" ")));

            System.out.println(k2.split(" the ").length);

            //Convert the string into an array of characters
            char[] ch2=k2.toCharArray();

            System.out.println(Arrays.toString(ch2));
        }
    }

