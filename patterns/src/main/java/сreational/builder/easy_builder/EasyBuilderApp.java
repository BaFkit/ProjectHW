package сreational.builder.easy_builder;

public class EasyBuilderApp {
    public static void main(String[] args) {
        System.out.println("Start EasyBuilder App!");
        System.out.println("******************\n");

        Report report = new Report
                .Builder("First quarter report 2021 year")
                .setTitle("Procurement")
                .setContent("Implemented successfully")
                .setTable("Table cost")
                .setPageNumber(1)
                .build();

        System.out.println(report);

        System.out.println(report.getHeader());
        System.out.println(report.getTable());
        System.out.println(report.getPageNumber());

        System.out.println("\n******************");
        System.out.println("EasyBuilder App is Done!");
    }
}
