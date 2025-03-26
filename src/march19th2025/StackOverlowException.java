package march19th2025;

public class StackOverlowException {

    public static void m1(){
        m2();
    }
    public static void m2(){
        m3();
    }
    public static void m3()
    {
        m1();
    }

    public static void main(String[] args) {

        m1();
    }
}
//here we are calling m1 from main, m1 calls m2 and m2 calls m3 and then m3 calls again m1 so it keeps on running and, then it throws stack overflow error it is not infinite loops
//it happens only when we keep on looping the methods only
