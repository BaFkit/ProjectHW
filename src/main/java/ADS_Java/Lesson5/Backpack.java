package ADS_Java.Lesson5;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Backpack {
    private Set<Thing> result = new LinkedHashSet<>();
    private int maxWeight;
    private int bestPrice;

    public Backpack(int maxWeight, ArrayList<Thing> things){
        this.maxWeight = maxWeight;
        bestThings(things);
    }

    public Set<Thing> resultBestThings() {
        return result;
    }

    public void bestThings(ArrayList<Thing> things) {
        for (int i = 0; i < things.size(); i++) {
            if(sumW(things) <= maxWeight) {
                int sp = sumP(things);
                if(sp > bestPrice) {
                    result.clear();
                    bestPrice = sp;
                    result.addAll(things);
                }
            }
            Thing temp = things.get(i);
            things.remove(i);
            bestThings(things);
            things.add(i, temp);
        }

    }

    public int sumW (ArrayList<Thing> things) {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.getWeight();
        }
        return sum;
    }

    public int sumP (ArrayList<Thing> things) {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.getPrice();
        }
        return sum;
    }

}
