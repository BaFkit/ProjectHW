package Java_2.Lesson3.part1;

import java.util.HashMap;

public class HomeWorkApp {


    public static void main(String[] args) {

        HashMap <String, Integer> map = new HashMap<>();

        String[] array = new String[]{
                "Барселона",
                "Зенит",
                "Манчестер Юнайтед",
                "Ливерпуль",
                "Ювентус",
                "Челси",
                "Манчестер Юнайтед",
                "Зенит",
                "ЦСКА",
                "Бавария",
                "Спартак",
                "Локомотив",
                "Милан",
                "Арсенал",
                "Ювентус",
                "Зенит",
        };

        for (String a: array) {
            if(!map.containsKey(a)){
                map.put(a, 1);
            }else {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
        }
        for (String a: map.keySet()){
            System.out.println(a + " - " + map.get(a));
        }
    }
}
