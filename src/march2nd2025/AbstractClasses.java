package march2nd2025;

abstract class GrandP
{
    abstract void grandP();
}

//We can extend one abstract class with another abstract class
abstract class Pare extends GrandP
{
    abstract void pare();
}

class Chi extends Pare
{

    @Override
    void pare() {
        System.out.println("Writing the logic for the method present in the parent class");
    }

    @Override
    void grandP() {
        System.out.println("Writing the logic for the method present in the grand parent class");
    }
}



public class AbstractClasses {
}
