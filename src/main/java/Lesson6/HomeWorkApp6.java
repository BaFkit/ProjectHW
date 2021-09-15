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
            a.run(220);
            a.swim(10);
            System.out.println();
        }
        System.out.println("Всего животных: " + Animal.countAnimal);
        System.out.println("Собак: " + Animal.countDog);
        System.out.println("Кошачих: " + Animal.countCat);

    }

}