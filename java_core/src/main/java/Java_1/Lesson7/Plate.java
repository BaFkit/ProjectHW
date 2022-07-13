package Java_1.Lesson7;

public class Plate {
    private int food;
    public Plate(int food) {
        if(food > 0) {
            this.food = food;
        }else if (food == 0){
            System.out.println("В тарелку не положили еды");
        }else {
            System.out.println("В тарелке не может быть отрицательное количество еды.");
        }
    }
    public boolean decreaseFood(int n) {
        if(food > 0) {
            food -= n;
            return true;
        }else {return false;}
    }

    public void addFood(int n){
        if (n > 0) {
            food += n;
            System.out.println("В тарелку положили " + n + " еды");
        }
    }
    public int getFood(){
        return food;
    }
    public void info() {
        System.out.println("В тарелке: " + food);
    }
}
