package ads.Lesson4;


public class DequeLinkedListImpl<E> extends TwoSideLinkedListImpl<E> implements Deque<E>{

    @Override
    public boolean insertLeft(E value) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(value, first, null);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        super.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return super.removeFirst();
    }

    @Override
    public E removeRight() {
        E item = last.item;
        Node<E> prev = last.prev;
        last.item = null;
        last.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return item;
    }

    @Override
    public void displayLeft() {
        super.display();
    }

    public void displayRight(){

        StringBuilder sb = new StringBuilder("[");
        Node<E> current = last;

        while (current != null) {
            sb.append(current.item);
            if (current.prev != null) {
                sb.append(" -> ");
            }
            current = current.prev;
        }
         sb.append("]");
        System.out.println(sb.toString());
    }
}
