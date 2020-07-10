package com.example.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CourierServiceProcessor implements Runnable {
    private final String [] items;
    private final CountDownLatch countDownLatch;

    public CourierServiceProcessor(String[] items, CountDownLatch countDownLatch) {
        this.items = items;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for(int i=0; i<items.length;i++){
            try{
                System.out.println("Before processing the order, CountDownLatch value " +
                        ":"+countDownLatch.getCount());

                Thread.sleep(5000);
                System.out.println("Completed phase : "+items[i]);
                countDownLatch.countDown();

                System.out.println("After processing the order, CountDownLatch value " +
                        ":"+countDownLatch.getCount());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
