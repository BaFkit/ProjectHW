package Java_3.Lesson4;

public class HomeWorkApp {
    private final Object obj = new Object();
    private volatile char letter = 'A';

    public void printA(){
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'A') {
                        obj.wait();
                    }
                    System.out.print("A");
                    letter = 'B';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB(){
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'B') {
                        obj.wait();
                    }
                    System.out.print("B");
                    letter = 'C';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC(){
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'C') {
                        obj.wait();
                    }
                    System.out.print("C");
                    letter = 'A';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        HomeWorkApp printABS = new HomeWorkApp();
        Thread thread1 = new Thread(() -> {
            printABS.printA();
        });
        Thread thread2 = new Thread(() -> {
            printABS.printB();
        });
        Thread thread3 = new Thread(() -> {
            printABS.printC();
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
