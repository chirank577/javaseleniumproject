package february24th2025;

public class MethodChanning {
    public static void main(String[] args) {
        Ecommerce e=new Ecommerce("chiru","singh");
        e.loginToTheApp()
                .searchFoProducts("phone")
                .applyFilter()
                .addProdToCart()
                .checkOut();
    }
}
