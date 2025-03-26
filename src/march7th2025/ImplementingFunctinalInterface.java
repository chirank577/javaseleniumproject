package march7th2025;

public class ImplementingFunctinalInterface {


    public static void main(String[] args) {
        //first way: writing the logic of the method inside an anonymous inner class
        //here we are not creating the object of the Interface
        // we are writing our logic inside anonymous class
        SampleFunctionalInterface s=new SampleFunctionalInterface() {
            @Override
            public void display() {
                System.out.println("I am being called from functional interface");

            }
        };
        s.display();
        //Lambda Expression works with the functional interface
        //second way: using lambda expressions:
        //Concise way of writing the code or logic for that particular functional interfaces
        SampleFunctionalInterface s1=()->
        {
            System.out.println("I am being called from lambda function");
            int a=2, b=9;
            int c=a+b;
            System.out.println(c);
        };
        s1.display();

        ReturnLambda r=(int a,int b)-> {
            return a+b;
        };
        System.out.println(r.sumofnum(23,44));
    }


}
