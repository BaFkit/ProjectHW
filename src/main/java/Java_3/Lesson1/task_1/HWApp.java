package Java_3.Lesson1.task_1;

import java.util.Arrays;

public class HWApp {

    public <T> void changePlace(T[] arr, int a, int b){
        if(a >= 0 && arr.length >= a && b >= 0 && arr.length >= b){
            T x = arr[a];
            arr[a] = arr[b];
            arr[b] = x;
        }else {
            System.out.println("Переданны некорректные аттрибуты");
        }
    }

    public static void main(String[] args) {

        HWApp app = new HWApp();
        String[] strArr = {"str1", "str2", "str3", "str4", "str5"};

        app.changePlace(strArr, 2, 4);

        for (String a: strArr) {
            System.out.print(a + " ");
        }
    }
}
