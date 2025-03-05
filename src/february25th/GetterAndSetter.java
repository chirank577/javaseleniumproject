package february25th;

public class GetterAndSetter {
}

class Players
{
    private String name;
    private int age;
    private String team;
    private String position;

    public void displayPlayerDetail()
    {
        System.out.println("Player Name is: "+name+" age of the player is "+age+" she playes for "+team+" she is the "+position+" of the team");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }



    public Players(String name, int age, String team, String position)
    {
        this.name=name;
        this.age=age;
        this.team=team;
        this.position=position;

    }
}