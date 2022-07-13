package ads.Lesson8;

public class HashTableMy <K, V> implements HashTable<K, V> {

    private final Item<K, V>[] data;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;
        private Item<K, V> next;

        public Item(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
        public Item<K, V> getNext() {
            return next;
        }
        public void setNext(Item<K, V> next) {
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }
        @Override
        public V getValue() {
            return value;
        }
        @Override
        public void setValue(V value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    public HashTableMy(int initialCapacity) {
        data = new Item[initialCapacity * 2];
    }
    public HashTableMy() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length){
            return false;
        }
        int index = hashFunc(key);
        if (data[index] == null) {
            data[index] = new Item<>(key, value);
            size++;
        }else {
            Item<K, V> item = data[index];
            while (item.getNext() != null && !item.getKey().equals(key)) {
                item = item.getNext();
            }
            if (item.getKey().equals(key)){
                item.setValue(value);
            }else {
                item.setNext(new Item<>(key, value));
                size++;
            }
        }
        return true;
    }
    private int hashFunc(K key) {
       return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        Item<K, V> item = getItemForKey(key);
        return item == null ? null : item.value;
    }

    private Item<K, V> getItemForKey(K key) {
        int index = hashFunc(key);
        Item<K, V> current = data[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        if (data[index] != null) {
            Item<K, V> prevItem = null;
            Item<K, V> item = data[index];
            while (item.getNext() != null && !item.getKey().equals(key)) {
                prevItem = item;
                item = item.getNext();
            }
            if (item.getKey().equals(key)) {
                if (prevItem == null) {
                    data[index] = item.getNext();
                    size--;
                }else {
                    prevItem.setNext(item.getNext());
                }
            }
            return item.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item<K, V> i : data) {
            sb.append("{");
            if (i != null) {
                Item<K, V> item = i;
                do {
                    sb.append(item.getValue()).append(", ");
                    item = item.getNext();
                } while (item != null);
            }
            sb.append("} ");
            sb.append("\n");
        }
        return sb.toString();
    }
}
