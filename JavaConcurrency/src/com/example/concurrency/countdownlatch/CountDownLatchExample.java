package com.example.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) {
        //Items ordered.
        String[] itemsOrdered ={"Pizza","PanCakes","Burger"};

        //set the count as number of the items ordered.
        final CountDownLatch countDownLatch = new CountDownLatch(itemsOrdered.length);
        Thread foodServiceProcessorThread = new Thread(new FoodServiceProcessor(itemsOrdered,countDownLatch));
        foodServiceProcessorThread.start();

        try{
            System.out.println("Order has received and is being processed");
            //Wait for other threads to complete the task.
            //After all the task completes, run further tasks in the main thread.
            countDownLatch.await();
            System.out.println("Order is ready to dispatch");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

class FoodServiceProcessor implements Runnable {
    private final String [] items;
    private final CountDownLatch countDownLatch;

    public FoodServiceProcessor(String[] items, CountDownLatch countDownLatch) {
        this.items = items;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (String item : items) {
            try {
                System.out.println("Before processing the order, CountDownLatch value " + ":" + countDownLatch.getCount());

                //Use your logic here during this sleep time
                Thread.sleep(5000);
                System.out.println("Item '" + item + "' has prepared");
                //Reduce the count after task has finished.
                countDownLatch.countDown();

                System.out.println("After processing the order, CountDownLatch value " + ":" + countDownLatch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
