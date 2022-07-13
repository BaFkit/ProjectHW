package ads.Lesson3;

public class SearchNumber {

    public static int searchSkipedNumber(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int base = (start + end)/2;
            if (arr[base] - base == 1){
                start = base + 1;
            }else{
                end = base - 1;
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16};
        int[] arr3 = {1, 2, 4};
        int[] arr4 = {1, 2, 3, 4, 5, 6, 8};

        System.out.println("Массив 1 - отсутствует число: " + searchSkipedNumber(arr1));
        System.out.println("Массив 2 - отсутствует число: " + searchSkipedNumber(arr2));
        System.out.println("Массив 3 - отсутствует число: " + searchSkipedNumber(arr3));
        System.out.println("Массив 4 - отсутствует число: " + searchSkipedNumber(arr4));
    }
}
