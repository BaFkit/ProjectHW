package ads.Lesson2;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {



        Notebook[] notebook = MyValue.getNotebooks(10000);
        System.out.println(Arrays.toString(notebook));
        long startTime = System.currentTimeMillis();
        NotebookSort.sort(notebook);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(notebook));




//        Integer[] arr = {7, 4, 1, 0, 5, 6, 9, 8, 2, 3, 5, 6, 7, 0, 1, 5};
//        SelectionSortPlus.sort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");

    }
}
