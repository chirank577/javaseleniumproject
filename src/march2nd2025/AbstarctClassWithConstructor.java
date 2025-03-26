package march2nd2025;

abstract class Players{

    String playerName;

    //We cannot have abstract variables only abstract classes and methods
    public Players(String playerName)
    {
        this.playerName=playerName;
    }

    abstract void displayDetails();

    public void playMatch()
    {
        System.out.println("Playing a new match");
    }


}

class IndianTeam extends Players
{
    //If the parent class is having a parameterized constructor, then the child class should also
    //have a parameterized constructor too.
    public IndianTeam(String playerName) {
        super(playerName);
    }

    @Override
    void displayDetails() {
        System.out.println("Displaying the Player Details from the Indian Team");
    }
}



public class AbstarctClassWithConstructor {

    public static void main(String[] args) {

        IndianTeam indianTeam=new IndianTeam("Kohli");

        indianTeam.displayDetails();
        indianTeam.playMatch(); //We can call the concreate methods using the regular appraoch that we have followed during inheritance

    }
}
