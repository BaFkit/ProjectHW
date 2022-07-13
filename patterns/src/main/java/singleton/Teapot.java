package singleton;

public class Teapot {

    private float volume;

    public Teapot(float volume) {
        this.volume = volume;
    }

    public String makeTea() {
        return "The teapot with " + addWater(volume);
    }

    private String addWater(float volume) {
        WaterSpring instance = WaterSpring.getInstance();
        System.out.println("Teapot - " + instance);
        return instance.getWater(volume);
    }

}
