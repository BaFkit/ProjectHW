package сreational.factory_method;

public class GroceryStore implements Store {
    @Override
    public void saleGood() {
        System.out.println("Tasty food.");
    }
}
