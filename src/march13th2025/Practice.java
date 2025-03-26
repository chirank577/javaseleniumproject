package march13th2025;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        int k=2;

        int newArr[]=new int[arr.length];

        for(int i=0;i<arr.length;i++)
        {
            if(i+k<arr.length)
            {
                newArr[i+k]=arr[i];
            }
            else
            {
                newArr[i+k-arr.length]=arr[i];
            }
        }
        System.out.println(Arrays.toString(newArr));



    }
}
