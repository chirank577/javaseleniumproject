package february24th2025;
//constructor type of method that allows you to structure the process of object creation.
//Every time when we create an object, a constructor is executed by default.
//constructor is special type of method, which need not be called explicitly.

//syntax of constructor
//accessmodifer Classname() {block of code}

//Encapsulation hiding the data variable from outside world nd providing acess to the data variables with the help of methods


class Name {
    //variable that are declared at the class level are called instance variable
    private String fName;
    private String lName;
    private int age;


    public void display() {
        // Step 1: Declare method variables (local variables)
        String fName = "ankit"; // Local variable (method scope)
        String lName = "singh"; // Local variable (method scope)

        System.out.println("Method variables: " + fName + " " + lName);
        System.out.println("Constructor values: " + this.fName + " " + this.lName);
        System.out.println("age: "+age);
    }

    public Name() { // Constructor initializes instance variables
        System.out.println("Default constructor being executed");
        fName = "chiranjivi";
        lName = "singh";
    }
    public Name(String ffName, String flName)// this is also called method overloading same method name but different parameterised value
    {
        //either you can have different name in new constructor or use this keyword if have same name as class variable
       fName=ffName;
       lName=flName;

    }
    Name(int age)
    {
        // this keyword is used to differentiate between the instance variable and local variable
        this.age=age;
    }
}

public class Constructorconcept {
    public static void main(String[] args) {
        Name n1 = new Name(); // Constructor executes first
        Name n2= new Name("tejash","Gupta");
        Name n3=new Name(23);
        n1.display(); // Calls display method
        n2.display();
        n3.display();
    }
}
