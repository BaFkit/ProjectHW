package ADS_Java.Lesson2;

import java.util.ArrayList;
import java.util.Random;

public class MyValue {

    private static final Random random = new Random();

    public static int getNumber(int from, int to, int gap) {
        ArrayList <Integer> arrayList = new ArrayList<>();
        for (int i = from, j = 0; i <= to; i+=gap,  j++) {
            arrayList.add(i);
        }
        return arrayList.get(random.nextInt(arrayList.size()));
    }

    public static Brand getBrand(){
        Brand[] brand = {Brand.Lenuvo, Brand.Asos, Brand.MacNote, Brand.Eser, Brand.Xamiou};
        return brand[random.nextInt(5)];
    }

    public static Notebook[] getNotebooks(int number){
        Notebook[] notebooks = new Notebook[number];
        for (int i = 0; i < number; i++) {
            notebooks[i] = new Notebook();
        }
        return notebooks;
    }
}
