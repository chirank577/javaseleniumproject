package february24th2025;

import com.sun.security.jgss.GSSUtil;

public class Ecommerce {
    private String userName;
    private String password;

    public Ecommerce()
    {

    }

    public Ecommerce(String userName, String password)
    {
        this.userName=userName;
        this.password=password;
    }
    public Ecommerce loginToTheApp()
    {
        System.out.println("Logged into the application with the username: "+userName+" password "+password);
       // return new Ecommerce(); instead of this bc it creates new object everytime in all the method
        return this;
    }
    public Ecommerce searchFoProducts(String productName)
    {
        System.out.println("searching for the product "+productName);
        return this;
    }
    public Ecommerce applyFilter()
    {
        System.out.println("applying filter to he product");
        return this;
    }
    public Ecommerce addProdToCart()
    {
        System.out.println("adding product to the cart");
        return this;
    }
    public Ecommerce checkOut()
    {
        System.out.println("buying the product");
        return this;
    }


}
