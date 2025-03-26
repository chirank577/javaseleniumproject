package march3rd2015;



//Creating my own exception class where we can customize the Exception handling as per the requirement
public class GenericExceptions extends RuntimeException {

    public GenericExceptions(String message)
    {
        super(message); //Referring to the parent class constructor
    }
}
