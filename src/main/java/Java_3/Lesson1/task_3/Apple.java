package Java_3.Lesson1.task_3;

public class Apple extends Fruit{

    private final double weight = 1.0;


    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
