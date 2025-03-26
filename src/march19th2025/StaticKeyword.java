package march19th2025;

//static methods and static variables are always binded to the class
//any specific method or variables will never be part of the heap memory
//non-static methods and non static variables are always binded to the object/heap memory

//all the static methods and varible will be present in the permanent space or meta gen memory and it is not fixated it increase or decrease based on the heap memory
//before jdk1.8 static memory was fixed and if complete space was occupied then it will throw outof memory error
class Cars{

    String model;
    String color;
    double price;
    static int noOfWheels=4;// no need to create an object to access this variable because the noOfWheels is same for any car

    public void display()
    {
        System.out.println("I have a car "+model+" it is "+color+" in color"+". i had to pay "+price+" money.");
    }
}
public class StaticKeyword {
    public static void main(String[] args) {

        System.out.println(Cars.noOfWheels);
        Cars c1=new Cars();
        c1.color="black";
        c1.model="Charger";
        c1.price=400000;
        c1.display();

    }
}
