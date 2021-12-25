package Java_3.Lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Semaphore semaphore = new Semaphore(CARS_COUNT / 2);
        CountDownLatch cdlEnd = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdlPrepare = new CountDownLatch(CARS_COUNT);
        CyclicBarrier cyclicBarrierStart = new CyclicBarrier(CARS_COUNT);
        CyclicBarrier winner = new CyclicBarrier(1);
        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdlPrepare, cyclicBarrierStart, cdlEnd, winner);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        cdlPrepare.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


        cdlEnd.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
