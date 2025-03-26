package march17th2025;

public record Record(String data, int value) {
    void display()
    {
        System.out.println("data is "+data+" and the value is: "+value);
    }
}
