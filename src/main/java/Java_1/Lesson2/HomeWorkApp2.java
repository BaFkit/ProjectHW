package Java_1.Lesson2;

public class HomeWorkApp2 {


    public static boolean Required_Sum(int a, int b){

          return a + b >= 10 && a + b <= 20; // - Предложенный Идеей вариант. Разобрался в нем. Решил воспользоваться им.

//        if (a + b >= 10 && a + b <= 20){   // - Мой вариант.
//            return true;
//        }else {
//            return false;
//        }
    }

    public static void Print_Positive_or_negative(int a) {
        if (a >= 0) {
            System.out.println(a + " - Положительное число");
        } else {
            System.out.println(a + " - Отрицательоне число");
        }
    }

    public static boolean Find_Positive_or_negative(int a){
        return a < 0;
    }

    public static void Print_info(String info, int  a){
        for (int i = 1; i <= a; i++){
            System.out.println(info);
        }
    }

    public static boolean Leap_year(int a){
        if (a%400 == 0){
            return true;
        }else if (a%100 == 0 ){
            return false;
        }else if (a%4 == 0){
            return true;
        }else {
            return false;
        }
    }






    public static void main(String[] args) {

         System.out.println(Required_Sum(10, 10));

         Print_Positive_or_negative(0);

         System.out.println(Find_Positive_or_negative(-5));

         Print_info("Hello", 5);

         System.out.println(Leap_year(2200));
    }


}
