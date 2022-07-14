package сreational.factory_method;

public class GroceryStoreFactory implements StoreFactory {
    @Override
    public Store createStore() {
        return new GroceryStore();
    }
}
