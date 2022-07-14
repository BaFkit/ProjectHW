package сreational.singleton;

public class SingletonApp {
    public static void main(String[] args) {
        System.out.println("Start Singleton App");
        System.out.println("*********************\n");


        Singleton singleton1 = Singleton.getInstance();
        System.out.println("1 - " + singleton1);

        Singleton singleton2 = Singleton.getInstance();
        System.out.println("2 - " + singleton2);

        WaterSpring waterSpring = WaterSpring.getInstance();
        float someWater = 2.5f;
        System.out.println("4 - " + waterSpring.getWater(someWater));

        someWater = 1.5f;
        System.out.println("5 - " + waterSpring.getWater(someWater));

        System.out.println("WaterSpring - " + waterSpring);

        float waterForTea = 3.7f;
        Teapot teapot = new Teapot(waterForTea);
        System.out.println("6 - " + teapot.makeTea());


        Multiton multiton = Multiton.getInstance("1");
        System.out.println("7 - multiton 1: " + multiton);

        multiton = Multiton.getInstance("2");
        System.out.println("8 - multiton 2: " + multiton);

        LimitedMultiton limitedMultiton = LimitedMultiton.getInstance(LimitedMultiton.Count.ONE);
        System.out.println("9 - limited multiton ONE " + limitedMultiton);

        limitedMultiton = LimitedMultiton.getInstance(LimitedMultiton.Count.TWO);
        System.out.println("10 - limited multiton TWO " + limitedMultiton);


        System.out.println("\n*********************");
        System.out.println("Singleton App is Done");
    }
}
