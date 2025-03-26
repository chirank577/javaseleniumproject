package march3rd2015;


//final keyword is used at a variable level or at a class level
//When the class is marked as final, that means we cannot use this class for inheritance
final class KeyData {

    public void showData() {
        System.out.println("Hello World From Show Data");
    }
}

//We cannot use a combination of final and abstract at a class level
//final abstract class SamplesData
//{
//
//}


//public class FinalKeyword extends KeyData {
public class FinalKeyword {

    public static void main(String[] args) {

        //If we declare a variable as final, we cannot modify the data
        //It is used to declare some constant values where we do not want to others to change the data
        final double PI = 3.14;

//        PI=4.521; //Throws a compilation error stating that cannot modify the final variable
    }
}
