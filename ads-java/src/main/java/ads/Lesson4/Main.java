package ads.Lesson4;


public class Main {

    public static void main(String[] args) {

        DequeLinkedListImpl<Integer> linkedList = new DequeLinkedListImpl<>();


        linkedList.insertLeft(1);
        linkedList.insertLeft(2);
        linkedList.insertLeft(3);
        linkedList.insertLeft(4);
        linkedList.insertLeft(5);
        linkedList.insertLeft(6);
        linkedList.insertLeft(7);
        linkedList.insertLeft(8);

        linkedList.insertRight(9);
        linkedList.insertRight(10);
        linkedList.insertRight(11);
        linkedList.insertRight(12);
        linkedList.insertRight(13);
        linkedList.insertRight(14);

        linkedList.displayLeft();
        linkedList.displayRight();


        linkedList.removeLeft();
        linkedList.display();

        linkedList.removeRight();
        linkedList.display();

        linkedList.remove(1);
        linkedList.display();

        System.out.println("********************************");

        for (Integer a:linkedList) {
            System.out.println("value: " + a);
        }



    }

}
