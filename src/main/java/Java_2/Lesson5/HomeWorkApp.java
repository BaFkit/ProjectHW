package Java_2.Lesson5;


public class HomeWorkApp {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void firstMethod(){
        float[] array = new float[SIZE];
        for (int i = 0; i < array.length; i++){
            array[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения в первом методе: " + (endTime - startTime) + " мс");
    }


        public static void secondMethod() throws InterruptedException {
        float[] array = new float[SIZE];
        for (int i = 0; i < array.length; i++){
            array[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        float[] firstHalf = new float[HALF];
        float[] secondHalf = new float[HALF];;

        System.arraycopy(array, 0, firstHalf, 0, HALF);
        System.arraycopy(array, HALF, secondHalf, 0, HALF);

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < firstHalf.length; i++) {
                        firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < secondHalf.length; i++) {
                        secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + (i+HALF) / 5) * Math.cos(0.2f + (i+HALF) / 5) * Math.cos(0.4f + (i+HALF) / 2));
                    }
                }
            });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(firstHalf, 0, array, 0, HALF);
        System.arraycopy(secondHalf, 0, array, HALF, HALF);

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения во втором методе: " + (endTime - startTime) + " мс");
    }




    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

}


