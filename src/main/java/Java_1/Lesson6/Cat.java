package Java_1.Lesson6;

public class Cat extends Animal{

    private static int countCat;

    Cat(String name){
        super(name);
        countCat += 1;
    }
    public static int getCount(){
        return countCat;
    }
    @Override
    public void run(int a){
        if (a > 0) {
            if(a <= 200) {
                System.out.println(name + " пробежал " + a + "м.");
            }else {
                System.out.println(name + " не может столько пробежать");
            }
        }else if (a == 0){
            System.out.println(name + " не побежал");
        }
    }
    @Override
    public void swim(int a) {
            System.out.println(name + " плавать не умеет");
    }

}
