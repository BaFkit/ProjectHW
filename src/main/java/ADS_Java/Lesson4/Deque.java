package ADS_Java.Lesson4;

public interface Deque<E> extends LinkedList<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();

    void displayLeft();
    void displayRight();
}