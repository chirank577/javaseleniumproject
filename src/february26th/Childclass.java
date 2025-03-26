package february26th;

public class Childclass extends Father{
    public void Triangle()
    {
        System.out.println("i am from child triangle");
        super.Triangle();// it can access the protected method
    }
    public void rectangle()
    {
        System.out.println("i am from child rectangle");
        super.rectangle();
    }
    @Override
    //method overriding is run time polymorphism. means during execution it will decide which class method needs to be excuted
    public void square()
    {
        System.out.println("i am from child square");
        super.square();
    }
}
