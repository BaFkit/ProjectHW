package Java_1.Lesson6;

public class Dog extends Animal{

    private static int countDog;

    Dog(String name){
        super(name);
        countDog += 1;
    }
    public static int getCount(){
        return countDog;
    }

    @Override
    public void run(int a){
        if (a > 0) {
            if (a <= 500) {
                System.out.println(name + " пробежал " + a + "м.");
            } else {
                System.out.println(name + " не может столько пробежать");
            }
        }else if (a == 0){
            System.out.println(name + " не побежал");
        }

    }
    @Override
    public void swim(int a) {
        if (a > 0) {
            if (a <= 10) {
                System.out.println(name + " проплыл " + a + "м.");
            }else {
                System.out.println(name + " не может столько проплыть");
            }
        }else if (a == 0){
            System.out.println(name + " не поплыл");
        }
    }
}
