package сreational.builder.industrial_builder;

public class BuilderApp {
    public static void main(String[] args) {
        System.out.println("Start Builder App!");
        System.out.println("******************\n");

        Director director = new Director();
        director.setBuilder(new LightIndustrialUnitBuilder());
        IndustrialUnit industrialUnit = director.buildIndustrialUnit();
        System.out.println(industrialUnit);

        director.setBuilder(new HeavyIndustrialUnitBuilder());
        System.out.println(director.buildIndustrialUnit());





        System.out.println("\n******************");
        System.out.println("Builder App is Done!");
    }
}
