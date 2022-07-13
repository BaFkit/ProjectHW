package Java_2.Lesson1;

public class Robot implements Subject{

    private String name;
    private int maxLength;
    private int maxHeight;

    private boolean admittance = true;

    public Robot(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
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
    public String getName() {
        return name;
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
        System.out.println("Робот " + name + " бежит");
    }

    @Override
    public void jump() {
        System.out.println("Робот " + name + " прыгает");
    }
}
