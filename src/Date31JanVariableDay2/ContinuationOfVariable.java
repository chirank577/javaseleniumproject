package Date31JanVariableDay2;

public class ContinuationOfVariable {
    public static void main(String[] args) {

        int a4;//accepts a value from -2^31 to 2^31-1
        char a5;//accepts a value like 'a','b','&'
        double a6; //accepts value upto 16 significants digits
        boolean a7; //accepts a value in true and false
        float a8;//accepts value  upto 5 significants digits
        short b10; //accepts value between -32768 to 32767
        byte b11;//accepts value between -128 to 127
        long b12;//accepts value from -2^63 to 2^63-1

        a4=-2495;// interger occupies 4 bytes of memory
        a5='r';// char occupies 2 bytes memory
        a6=42.666666666;// double occupies 8 byte memory
        a7=false;// boolen occupies 1 bit memory
        a8=4.24f;// float occupies 4 bytes memory/ use letter f while initializing the float value
        b10=-4893;//short occupies 2 bytes
        b11=127;// byte occupies 1 byte of memory
        b12=8235772356l;//long occupies 8 bytes memory/ use letter l while initializing the long value

        // if we do not know the right data type, but we need to store the value inside the variable, then we use var
        var v1=40l;
        System.out.println(v1);
        //v1=true; its wrong it can only take same data type  has been defined in first var

        v1=45677; // but if we use same data type n which has more capability it will work

        System.out.println(v1);

        // **then there are two more types of variable: transient and volatile variables
        System.out.println("Value of char is "+a5);

        // Another way of using a statement along with variable without concatenating:
        //.printf()---> prints the data in a formatted way but cursor does not move to next line
        //%d--> represent an integer
        //%s--> represent a string
        //%f --> represent a float value
        //%c --> represent a character
        //%b --> boolean
        System.out.printf("value of a1 %d\n",v1);
        System.out.printf("Value of string is %d and the value of char is %c \n",a4,a5);
        System.out.printf("Value of boolean %b\n", a7);

        var v2=4.25f;
        var v3=95325;
        System.out.println(v2+v3);
        var v4="bbvbv";
        var v5=566;
        System.out.println(v4+v5);

        }

    }

