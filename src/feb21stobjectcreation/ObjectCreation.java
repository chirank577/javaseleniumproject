package feb21stobjectcreation;
//in the same java fil, we can have mutiple classes, but only one public class should be present
// class is nothing but a blueprint or prototype
//class is an entity that consist of variable and methods
class Names{
    String firstName="chiru";
    String lastName="rajput";
    String middleName="narayan";

     void display()
    {
        String firstName="ankit";
        String lastName="singh";
        String middleName="kumar";
        System.out.println("First Name is:"+firstName);
        System.out.println("middle name is :"+middleName);
        System.out.println("Last Name is:"+lastName);

    }
class Phonenumber{


    }

}

public class ObjectCreation {
    public static void main(String[] args) {
        //we need to create a reference/object of the class in order to access a particular class variables and methods
        // we have two kinds of memory in java memory map 1.Heap 2. stack
        // and whole java memory is surrounded by JVm(java virtual machine)
        // stack memory is the place where all the variables will be declared and all the executions of the program will be done.
        // we delare the variable in stack memory
        //so new Names() creates a clone of the Names class in heap
        Names n1= new Names();
        n1.display();
        Names n2= new Names();
        n2.firstName="tejas";
        n2.lastName="gupta";

        System.out.println(n1.firstName);

    }
}
