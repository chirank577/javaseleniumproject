package february25th;

public class CRUDOperations {
    //crud= create read update delete
    public static void main(String[] args) {
        Players p=new Players("Jevania",29,"rockit","head");
        p.displayPlayerDetail();
        System.out.println(p.getName());
        System.out.println(p.getAge());
        //update the value of the data
        p.setPosition("team lead");
        System.out.println(p.getPosition());
        System.out.println(p.toString());

    }


}
