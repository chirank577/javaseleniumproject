package february26th;

public class Inheritance {
    public static void main(String[] args) {
        Childclass c=new Childclass();
        c.square();
        GrandFather s=new Father();
        s.square();
        c.Triangle();
        s.Triangle();
    }
}
