package Lesson6;

public abstract class  Animal {

    Animal(String name){
        this.name = name;
        countAnimal += 1;
    }

    String name;
    private static int countAnimal;

    public static int getCount(){
        return countAnimal;
    }

    public abstract void run(int a);

    public  abstract void swim(int a);

}

