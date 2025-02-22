package Feb11forloops;

import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) {

        Scanner s1=new Scanner(System.in);//system.in means reading the data from console
        System.out.println("Enter your first number");
        int a=s1.nextInt();

        System.out.println("enter your second number");
        int b=s1.nextInt();

        System.out.println("sum of your given numbers are "+(a+b));

        //read a string s1.next()
        //read the first character from the console s1.next().charAt(0)

    }
}
