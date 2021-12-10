package Java_3.Lesson1.task_3;

public class HWApp {

    public static void main(String[] args) {

        Box <Apple> box_1 = new Box<>("Box 1", new Apple(), new Apple(), new Apple(), new Apple(), new Apple());

        Box <Orange> box_2 = new Box<>("Box 2", new Orange(), new Orange(), new Orange());

        box_1.putBox(new Apple());
        box_2.putBox(new Orange());


        Box <Apple> box_3 = new Box<>("Box 3");

        System.out.println("Вес " +box_1.name+ " с яблоками: " + box_1.getWeight());
        System.out.println("Вес " +box_2.name+ " c апельсинами: " + box_2.getWeight());

        System.out.println("*********************************************************");

        System.out.println("Сравниваем коробки " +box_1.name+ " и " +box_2.name+": "+ box_1.compare(box_2));
        System.out.println("*********************************************************");

        System.out.println("Смотрим, что в коробках:");
        box_1.boxEmpty();
        box_2.boxEmpty();
        box_3.boxEmpty();

        System.out.println("*********************************************************");

        System.out.println("Пересыпаем из одной коробки в другую и смотрим что стало:");
        box_1.moveTo(box_3);

        box_1.boxEmpty();
        box_3.boxEmpty();

    }
}
