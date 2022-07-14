package сreational.object_pool;

import java.util.LinkedList;
import java.util.List;

public class ObjectPoolApp {
    public static void main(String[] args) {
        ObjectPool objectPool = new ObjectPool();
        PooledObject pooledObject = objectPool.getPooledObject();
        objectPool.releasePooledObject(pooledObject);

    }
}
    class PooledObject {}

    class ObjectPool {
        List<PooledObject> free = new LinkedList<>();
        List<PooledObject> used = new LinkedList<>();

        public PooledObject getPooledObject() {
            PooledObject pooledObject;
            if (free.isEmpty()) {
                pooledObject = new PooledObject();
                free.add(pooledObject);
            } else {
                pooledObject = free.get(0);
                used.add(pooledObject);
                free.remove(pooledObject);
            }
            return pooledObject;
        }

        public void releasePooledObject(PooledObject pooledObject) {
            used.remove(pooledObject);
            free.add(pooledObject);
        }

    }
