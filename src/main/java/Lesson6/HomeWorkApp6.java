package Lesson6;

public class HomeWorkApp6 {

    public static void main(String[] args) {

        Animal[] animals = new Animal[]{
          new Dog("Sharik"),
          new Dog("Bobik"),
          new Dog("Jack"),
          new Cat("Barsik"),
          new Cat("Musya")
        };

        for (Animal a: animals){
            a.run(400);
            a.swim(10);
            System.out.println();
        }
        System.out.println("Собак всего: " + Animal.countDog);
        System.out.println("Кошачих всего: " + Animal.countCat);

    }

}
