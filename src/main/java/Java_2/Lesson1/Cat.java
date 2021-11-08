package Java_2.Lesson1;

public class Cat implements Subject{

    private String name;
    private int maxLength;
    private int maxHeight;

    private boolean admittance = true;

    public Cat(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAdmittance(boolean admittance) {
        this.admittance = admittance;
    }

    @Override
    public boolean getAdmittance() {
        return admittance;
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }


    @Override
    public void run() {
        System.out.println("Кот " + name + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Кот " + name + " прыгает");
    }
}
