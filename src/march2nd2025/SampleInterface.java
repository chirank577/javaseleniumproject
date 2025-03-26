package march2nd2025;


//Interface is not a class, which helps us in achieving 100% abstraction all the time

//Interface is loosely coupled
//Interface serves as a contract between client and the developer

//We have three different types of interfaces:
//1. Normal Interface
//2. Functional Interface --> Only one abstract method is allowed here and 80 percent of java works on abstract methods
//3. Marker Interfaces(Outdated and replaced with Annotations)
public interface SampleInterface {

    int a=40;
    //By Default all the methods are public
    //By Default all the variables are public, static and final
    //If the variables are declared as final, we cannot modify the data

    //Interfaces cannot have any objects or constructors

    void makePayment();
    void checkTransaction();
}
