package ads.Lesson2;

public class SelectionSortPlus {
    public static void sort(Integer[] arr) {
        int count = arr.length - 1;

        for (int i = 0; i < arr.length - 1; count--, i++) {
            int min = i;
            int max = count;
            for (int j = min + 1, l = max - 1; j < arr.length; j++, l--) {
                if (count == arr.length/2){
                    break;
                }
                if (arr[j] < arr[min]){
                    min = j;
                }
                if(arr[l] > arr[max]) {
                    max = l;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            int temp2 = arr[count];
            arr[count] = arr[max];
            arr[max] = temp2;
        }
    }
}
