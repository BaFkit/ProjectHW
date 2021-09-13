package Lesson6;

public abstract class  Animal {

    Animal(String name){
        this.name = name;
        countAnimal += 1;
    }

    String name;
    static int countAnimal;
    static int countCat;
    static int countDog;


    public abstract void run(int a);

    public  abstract void swim(int a);

}

