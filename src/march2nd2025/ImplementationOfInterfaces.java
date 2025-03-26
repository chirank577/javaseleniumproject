package march2nd2025;



interface AnotherSampleInterface
{
    int sumOfNumbers(int a, int b);
}

//implements keyword is used to write the logic for the methods present in the interface
public class ImplementationOfInterfaces implements SampleInterface, AnotherSampleInterface{
    @Override
    public void makePayment() {
        System.out.println("Making the payment");
    }

    @Override
    public void checkTransaction() {
        System.out.println("Checking the transactions");
    }

    public static void main(String[] args) {
        ImplementationOfInterfaces i1=new ImplementationOfInterfaces();
        i1.checkTransaction();
        i1.makePayment();
//        i1.a=55;
    }

    @Override
    public int sumOfNumbers(int a, int b) {
        return a+b;
    }
}
