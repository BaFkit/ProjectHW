package Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }
    public void eat(Plate p) {
        if (appetite > 0) {
            if (p.getFood() >= appetite) {
                satiety = p.decreaseFood(appetite);
                System.out.println(name + " поел");
            } else {
                System.out.println(name + " посмотрел в тарелку, увидел, что для него мало еды и ушел. ");
            }
        }else if(appetite == 0){
            System.out.println(name + " без аппетита, наверно он сытый");
            satiety = true;
        }else {
            System.out.println(name + " не может иметь отрицательный аппетит");
        }
    }
    public void getSatiety(){
         if (satiety){
             System.out.println(name + " сытый и довольный");
         }else {
             System.out.println(name + " остался голодным");
         }
    }
    public int getAppetite(){
        return appetite;
    }
    public String getName(){
        return name;
    }
}
