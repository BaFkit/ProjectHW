package Java_3.Lesson1.task_3;

public class Orange extends Fruit{

    private final double weight = 1.5;

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
