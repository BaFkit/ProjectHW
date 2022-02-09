package ADS_Java.Lesson6;

public interface Tree<E extends Comparable<? super E>> {


    boolean contains(E value);

    boolean add(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();


    void traverse(String mode);

    boolean printBalanced();

}

