package whilefeb10th;

public class LoopsFirstDay {
    public static void main(String[] args) {
        //llops means it keeps running until the condition is satisfied
        //four different kinds of loops
        /*1. while
        2. do while
        3. for
        4. for each
         */

        int a=40,b;
        b=40;
        while (a<100&& b>40)
        {


            System.out.println(a+b);
            a+=1;// self assignment operator
            b+=2;

            System.out.println(  "**************************************************************");
            b=50;
            a=50;
            while(b>40)
            {
                while(a<100) {
                    System.out.println(a + b);
                }
            }
            a+=2;
            b+=2;

        }
    }
}
