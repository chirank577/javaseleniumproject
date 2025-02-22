package Feb11forloops;

public class ForLoops {
    public static void main(String[] args) {
        //syntax of for loops;
        //for(initial value;condition to be satisfied;iterator)

        for (int i = 0; i < 100; i++)
            System.out.println(i);

        for (int j = 0; j < 10; j += 2) {
            System.out.println(j * j);
        }
        for (int j = 20; j > -10; j -= 10)
            System.out.println(j);
        for (int j = 0; j < 250; j++) {
            if (j == 200)
                break;
            else {
                while (j % 2 == 0) {
                    System.out.println(j * j * j);
                    j += 7;
                }
            }
        }
        // for(int i=0;i>-200;i=20)
        {
            // System.out.println(i*i-i/i);// throws an error since 0/0 is infinite
        }
        System.out.println("******************************************************************");
        for (String s = "Hellow World"; s.length() > 0; ) {


             s = "sample";
            for (; s.length() > 0; )//write the code using for loop where it behave like a while loop
            {
                s = s.substring(0, s.length() - 1);
                System.out.println(s);// so if i put print after condition it does not print the complete word

            }


        }


    }}
