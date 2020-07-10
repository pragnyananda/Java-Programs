package com.example.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Thread t1 = new Thread(new CabService(cyclicBarrier));
        t1.setName("Passenger1");
        t1.start();
        Thread.sleep(7000);

        Thread t2 = new Thread(new CabService(cyclicBarrier));
        t2.setName("Passenger2");
        t2.start();
        Thread.sleep(7000);

        Thread t3 = new Thread(new CabService(cyclicBarrier));
        t3.setName("Passenger3");
        t3.start();
        Thread.sleep(7000);

        Thread t4 = new Thread(new CabService(cyclicBarrier));
        t4.setName("Passenger4");
        t4.start();
        Thread.sleep(7000);

        Thread t5 = new Thread(new CabService(cyclicBarrier));
        t5.setName("Passenger5");
        t5.start();
        Thread.sleep(7000);

        Thread t6 = new Thread(new CabService(cyclicBarrier));
        t6.setName("Passenger6");
        t6.start();
        Thread.sleep(7000);

        Thread t7 = new Thread(new CabService(cyclicBarrier));
        t7.setName("Passenger7");
        t7.start();
        Thread.sleep(7000);

        Thread t8 = new Thread(new CabService(cyclicBarrier));
        t8.setName("Passenger8");
        t8.start();
        Thread.sleep(7000);

        Thread t9 = new Thread(new CabService(cyclicBarrier));
        t9.setName("Passenger9");
        t9.start();
        Thread.sleep(7000);
    }
}
