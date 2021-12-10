package Java_3.Lesson1.task_2;

import java.util.ArrayList;
import java.util.Arrays;


public class HWApp {

    public <E> ArrayList<E> transformsToArrayList(E[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void main(String[] args) {

        HWApp app = new HWApp();
        String[] strArr = {"str1", "str2", "str3", "str4", "str5"};

        System.out.println(app.transformsToArrayList(strArr));

    }

}
