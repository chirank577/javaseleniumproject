package march7th2025;

import java.util.Arrays;

public class Continuationof2DArrays {
    public static void main(String[] args) {

        int[] a1[] = new int[4][4];

        for(int i=0;i<a1.length;i++)
        {
            for(int j=0;j<a1[i].length;j++)
            {
                a1[i][j]=(i*j)-(i+j);
            }

        }
        System.out.println(Arrays.deepToString(a1));

        //print the data in the form of a matrix

        for (int i=0;i<a1.length;i++)
        {
            for (int j=0;j<a1[i].length;j++)
            {
               // System.out.println(a1[i][j]+" ");
                System.out.print(a1[i][j]+" ");
            }
            System.out.println();
        }
    }


}

