package Java_3.Lesson1.task_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <E extends Fruit> {

    public String name;
    private ArrayList<E> box;

    @SafeVarargs
    public Box(String name, E...Fruit){
        box = new ArrayList<>(Arrays.asList(Fruit));
        this.name = name;
    }

    public ArrayList<E> getBox (){
        return box;
    }

    public void putBox (E f){
        box.add(f);
    }

    public double getWeight(){
        double weight = 0;
        for (E a: box) {
            weight += a.getWeight();
        }
        return weight;
    }

    public boolean compare(Box <? extends Fruit> box){
        return this.getWeight() == box.getWeight();
    }

    public void moveTo (Box <E> box){
        System.out.println("Из " +this.name+ " пересыпали в "+box.name);
        box.box.addAll(this.box);
        this.box.clear();
    }

    public void boxEmpty(){
        if(box.isEmpty()){
            System.out.println("В " +this.name+ ": пусто");
        }else {
            System.out.println("В " +this.name+ ": " + box.size() + " фруктов");
        }
    }
}
