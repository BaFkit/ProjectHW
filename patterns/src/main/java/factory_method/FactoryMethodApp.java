package factory_method;

public class FactoryMethodApp {
    public static void main(String[] args) {

        System.out.println("Start Factory Method App!");
        System.out.println("***********************\n");

        Store storeGrocery1 = new GroceryStore();
        storeGrocery1.saleGood();

        StoreFactory storeFactoryGrocery = new GroceryStoreFactory();
        Store storeGrocery2 = storeFactoryGrocery.createStore();
        storeGrocery2.saleGood();

        StoreFactory storeFactoryWear = new WearStoreFactory();
        Store storeWear = storeFactoryWear.createStore();
        storeWear.saleGood();

        System.out.println("\n***********************");
        System.out.println("Factory Method is Done!");
    }
}
