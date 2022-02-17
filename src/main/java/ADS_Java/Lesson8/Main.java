package ADS_Java.Lesson8;

public class Main {

    public static void main(String[] args) {
        HashTable<Object, Object> hashTable = new HashTableMy<>(5);

        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(77, "Banana"), 100);
        hashTable.put(new Product(67, "Carrot"), 228);
        hashTable.put(new Product(60, "Lemon"), 250);
        hashTable.put(new Product(51, "Milk"), 120);
        hashTable.put(new Product(21, "Potato"), 67);

        hashTable.put(new Product(3, "butter"), 220);
        hashTable.put(new Product(5, "sugar"), 50);
        hashTable.put(new Product(15, "bread"), 25);

        System.out.println("Size is " + hashTable.size());

        hashTable.display();

        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));

        System.out.println("**********************************************************************");

        hashTable.remove(new Product(21, "Potato"));
        hashTable.remove(new Product(77, "Banana"));

        hashTable.display();

        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));

        System.out.println("**********************************************************************");

        hashTable.put(new Product(47, "Pineapple"), 228);

        hashTable.display();

        System.out.println("Cost Pineapple is " + hashTable.get(new Product(47, "Pineapple")));
    }
}
