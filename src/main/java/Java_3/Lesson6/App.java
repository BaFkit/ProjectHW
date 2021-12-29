package Java_3.Lesson6;


public class App {

    public static int[] returnArrayAfter4(int[] arr) {
        int[] rArr;
        for (int i =arr.length -1; i >=0; i--) {
            if (arr[i] == 4){
                rArr = new int[arr.length - i - 1];
                System.arraycopy(arr, i + 1, rArr, 0, arr.length - i - 1);
                return rArr;
            }
        }
        throw new RuntimeException("not found - 4");
    }

    public static  boolean checkArrayOn1or4 (int[] arr){
        if(arr == null) {
            return false;
        }
        for(int i: arr){
            if(i == 1 || i == 4) {
                return true;
            }
        }
        return false;
    }
}