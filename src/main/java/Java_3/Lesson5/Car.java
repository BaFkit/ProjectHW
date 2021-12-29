package Java_3.Lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private static String isWinner;
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch cdlPrepare;
    private CountDownLatch cdlEnd;

    private CyclicBarrier cyclicBarrierStart;
    private CyclicBarrier winner;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdlPrepare, CyclicBarrier cyclicBarrierStart, CountDownLatch cdlEnd, CyclicBarrier winner) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdlPrepare = cdlPrepare;
        this.cyclicBarrierStart = cyclicBarrierStart;
        this.cdlEnd = cdlEnd;
        this.winner = winner;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlPrepare.countDown();
            cyclicBarrierStart.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try {
            winner.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        if(isWinner == null){
            isWinner = name;
            System.out.println("WIN: " + name + " он пришел первым!!!");
        }
        cdlEnd.countDown();
    }
}

