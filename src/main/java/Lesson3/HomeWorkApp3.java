package Lesson3;

import java.util.Arrays;

public class HomeWorkApp3 {

    public static void main(String[] args) {

        System.out.println("Задача 1:");

        int[] arr = {0, 1, 1, 1, 0, 0, 1, 0, 0, 0};                // (1)
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                arr[i] = 1;
            }
            else{
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));


        System.out.println("\nЗадача 2:");

        int[] arr2 = new int[100];                                 // (2)
        for (int i = 0; i < arr2.length; i++){
            arr2[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr2));


        System.out.println("\nЗадача 3:");

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};        // (3)
        for (int i = 0; i < arr3.length; i++){
            if (arr3[i] < 6){
                arr3[i] *=2;
            }
        }
        System.out.println(Arrays.toString(arr3));


        System.out.println("\nЗадача 4:");

        int[][] arr4 = new int[5][5];                              // (4)

        for (int i = arr4.length - 1, j = 0; i >= 0; i--, j++){
            arr4[i][j] = 1;
            arr4[i][i] = 1;
        }

        for (int i = 0; i < arr4.length; i++){                   // Для проверки.
            for ( int j = 0; j <arr4[i].length; j++){
                System.out.print(arr4[i][j] + "\t");
            }
            System.out.println();
        }


        System.out.println("\nЗадача 5:");

        System.out.println(Arrays.toString(returnArray(10,5)));     // (5)


        System.out.println("\nЗадача 6:");

        int[] arr6 = {5, 20, 6, 3, 11, 2};                            // (6)
        int maxNumber = 0;
        for (int j : arr6) {
            if (j > maxNumber) {
                maxNumber = j;
            }
        }
        int minNumber = maxNumber;
        for (int j : arr6) {
            if (j < minNumber) {
                minNumber = j;
            }

        }
        System.out.println("Максимальный элемент массива = " + maxNumber);
        System.out.println("Минимальный элемент массива = " + minNumber);


        System.out.println("\nЗадача 7:");

        int[] arr7 ={2, 24, 3, 5, 18, 16};                          // (7)
        System.out.println(FindEqualSum(arr7));


        System.out.println("\nЗадача 8:");

        int[] arr8 = {4, 6, 3, 5, 1, 2};                             // (8)
        int a = - 2;
        displacement(arr8, a);
        System.out.println(Arrays.toString(arr8));


}




    public static int[] returnArray(int len, int initialValue){      // (5)
        int[] arr5 = new int[len];
        for (int i = 0; i < len; i++){
            arr5[i] = initialValue;
        }
        return arr5;
    }


    public static boolean FindEqualSum(int[] arr){                  // (7)
        int x = 0;
        boolean t = false;
        for(int i = arr.length - 1;i>0;i--){
            int y = 0;
            int i2 = arr.length - i;
            x+=arr[i];
            for(int j=0;j<(arr.length-i2);j++){
                y+=arr[j];
            }
            if (x == y){
                t = true;
                break;
            }
        }
        return t;
    }



    public static void displacement(int[] arr, int a) {               // (8)

    if (a >= 0) {
        for (int i = 0; i < a; i++) {
            for (int j = arr.length - 1, x = 0; j > 0; j--) {
                if (j == arr.length - 1) {
                    x = arr[j];
                }
                arr[j] = (arr[j - 1]);
                if (j == 1) {
                    arr[0] = x;
                }
            }
        }
    }else {
        for (int i = 0; i > a; i--) {
            for (int j = 0, x = 0; j < arr.length - 1; j++) {
                if (j == 0) {
                    x = arr[0];
                }
                arr[j] = arr[j + 1];
                if (j == arr.length - 2) {
                    arr[arr.length - 1] = x;
                }
            }
         }
      }
    }





}
