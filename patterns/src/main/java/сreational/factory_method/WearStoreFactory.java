package сreational.factory_method;

public class WearStoreFactory implements StoreFactory {
    @Override
    public Store createStore() {
        return new WearStore();
    }
}
