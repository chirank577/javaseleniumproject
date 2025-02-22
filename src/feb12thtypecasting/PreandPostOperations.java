package feb12thtypecasting;

public class PreandPostOperations {
    public static void main(String[] args) {
        /* post increment operation: value of a will be increased by 1 but it will not be updated immediately
        updted value will be stored in buffer/temp memory.*/

       int a =4;
        System.out.println(a++);// it will print 4 only bc increment is post
        System.out.println(a);
        System.out.println(++a);// it will print 6 since it is pre increment

         /* post decrement operation: value of a will be decreased  by 1 but it will not be updated immediately
        updted value will be stored in buffer/temp memory.*/

        System.out.println(a--);
        System.out.println(a);
        System.out.println(--a);
        a=10;
        System.out.println(a++ - --a * a-- + ++a - ++a);//10(11) - 10 *10(9) + 10 - 11



    }
}
