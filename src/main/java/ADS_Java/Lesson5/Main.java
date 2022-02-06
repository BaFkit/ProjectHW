package ADS_Java.Lesson5;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        ArrayList<Thing> things = new ArrayList<>();

        things.add(new Thing("Phone", 2, 2000));
        things.add(new Thing("Watch", 1, 1500));
        things.add(new Thing("Notebook", 4, 3000));
        things.add(new Thing("Guitar", 2, 3500));

        Backpack backpack = new Backpack(5, things);
        System.out.println(backpack.resultBestThings());
    }


}
