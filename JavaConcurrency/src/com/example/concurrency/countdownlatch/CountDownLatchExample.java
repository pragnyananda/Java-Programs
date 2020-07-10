package com.example.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) {
        String[] courierServices ={"WarehouseDispatch","ArrivedDestinationCity","ArrivedLocalHub"};

        final CountDownLatch countDownLatch = new CountDownLatch(courierServices.length);
        Thread courierServiceProcessorThread =
                new Thread(new CourierServiceProcessor(courierServices,countDownLatch));
        courierServiceProcessorThread.start();

        try{
            System.out.println("Order has received and is being processed");
            countDownLatch.await();
            System.out.println("Order is ready to dispatch");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
