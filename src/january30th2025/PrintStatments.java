package january30th2025;

import com.sun.tools.javac.Main;

public class PrintStatments {
    public static void main (String [] agrs)
    {
        System.out.println("Hello World");
        System.out.println(40-300*100/10);

        //Bodmas rule--> Brackets of division multiplication addition substraction
        System.out.println((40-300*20-400)+500/10-(420-30*10));
        System.out.print("these are the expamle it will be added to previous line of print ");
        System.out.print((40-300*20-400)+500/10-(420-30*10));// this will be combined with previous print
        System.out.println("\thi my name is chiru");//it will give space in two combined print

        //what does system.out.println do-> displays the data and move the cursor to the next line
        // where as system.out.print-> displays the data onto the console
       // System.out.print("these are the expamle it will be added to previous line of print ");
       // System.out.println((40-300*20-400)+500/10-(420-30*10)); /


        System.out.println("abcfg\b");//  \B works as backspace so it will remove g

        // \b \t \r \n etc are an escape characters and they will never be part of the string
        //\n goes to new line
        System.out.println("i am \n goint to the cafe");

        // err this is mainly used during the printing of any error messages n it prints as message. it will be displayed in red or orange colour
        System.err.println("Error Message Occured");
        System.out.println("i know how t will work");
        System.out.println("\tyeah i know");//  it adds space in the string
        System.err.println("Second Error Message Occured");







    }
}
