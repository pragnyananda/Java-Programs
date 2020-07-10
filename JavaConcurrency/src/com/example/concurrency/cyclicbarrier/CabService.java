package com.example.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CabService implements Runnable {

    private final CyclicBarrier cyclicBarrier;

    public CabService(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName()+" has arrived!");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+" is going to board the cab");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
