package march25thabstraction;
//abstract is nothing but revealing the functionality and hiding the implementation
// Abstract class is nothing but a class which contains abstract methods
//abstract methods is nothing but a method having no implementation at all

abstract class SampleClass
{
    //within the class, we can have abstract methods and concrete methods
    //we can not create am object for the abstract class
    abstract void display();//abs method
    public void showDetail()
    {
        //this is concrete method means regular method
    }
}

public class AbstractionClasses extends SampleClass{
    @Override
    void display() {

    }
}
