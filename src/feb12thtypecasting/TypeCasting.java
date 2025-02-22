package feb12thtypecasting;

public class TypeCasting {
    public static void main(String[] args) {
        int a=0;
        int b=20;
        char c='a';// when we include any character as part of any arithmetic operations, it will take the ASCII value
        System.out.println(a+b+c);
        //A-z=65-90
        //a-z=97-122
        //0-9=48-57
        // =32
        System.out.println((char)(a+b+c));// converting the ASCII values to a character
        //by doing this we are narrowing the datatype. convert a value which is of a bigger data type to a smaller data type

        // data type chart for primitive values:
        //double > float > long > integer > short >  char > byte > boolean
        //type casting always happen between tow primitive data type

        int d=5000;
        System.out.println((byte)(d));// converting tp byte type

        double e=50.6565665;
        System.out.println((int)e);// converting to int


    }
}
