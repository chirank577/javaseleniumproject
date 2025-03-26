package march17th2025;

public class ExecutingRecords {
    public static void main(String[] args) {
        Record r=new Record("hello",10);
        r.display();
        System.out.println(r.data());// do not need any getter and setter to use variable
        System.out.println(r.value());
    }
}
