package february26th;

public class Father extends GrandFather{
    protected void Triangle()
    {
        System.out.println("i am from father class triangle");
        super.Triangle();
    }
      void rectangle()
    {
        System.out.println("i am from father class rectangle");
        super.rectangle();
    }
    @Override
    public void square()
    {
        System.out.println("i am from father class square");
        super.square();
    }
}
