package сreational.builder.industrial_builder;

public class Director {

    IndustrialBuilder builder;

    public void setBuilder(IndustrialBuilder builder) {
        this.builder = builder;
    }

    IndustrialUnit buildIndustrialUnit() {
        builder.createIndustrial();

        builder.buildName();
        builder.buildTemperature();
        //сreational.builder.buildPressure();
        builder.buildVoltage();
        //сreational.builder.buildSupplierName();
        builder.buildOperatingStatus();

        IndustrialUnit industrialUnit = builder.getIndustrialUnit();

        return industrialUnit;
    }

}
