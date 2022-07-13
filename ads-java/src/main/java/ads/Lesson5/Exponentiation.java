package ads.Lesson5;

public class Exponentiation {

    public static double exponentiation(double a, double x) {
        if(x == 0){
            return 1.0;
        }
        if(x == 1.0 || x == -1.0){
            return a;
        }
        if(x < 0){
            return 1.0 / (exponentiation(a, (-1.0)*(x+1.0))*a);
        }else{
            return exponentiation(a, x-1.0)*a;
        }

    }


    public static void main(String[] args) {

        System.out.println(exponentiation(2,-5));

    }


}
