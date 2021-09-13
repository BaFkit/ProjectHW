package Lesson6;

public abstract class  Animal {

    Animal(String name){
        this.name = name;
    }

    String name;
    static int countCat;
    static int countDog;


    public abstract void run(int a);

    public  abstract void swim(int a);
}

