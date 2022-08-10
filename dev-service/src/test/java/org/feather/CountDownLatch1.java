package org.feather;

import java.util.concurrent.CountDownLatch;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: CountDownLatch1
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/9 22:19
 * @version: 1.0
 */
public class CountDownLatch1 {

    public static void main(String[] args) {
        usingJoin();
        usingCountDownLatch();
    }



    private  static  void  usingCountDownLatch(){

        Thread[] threads=new Thread[100];
        CountDownLatch latch=new CountDownLatch(threads.length);

        for (int i = 0; i <threads.length ; i++) {
            threads[i]=new Thread(()->{
                int result=0;
                for (int j = 0; j <100000 ; j++) {
                    result+=j;
                    latch.countDown();
                }
            });
        }

        for (int i = 0; i <threads.length ; i++) {
            threads[i].start();
        }
        try {
            latch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end latch");

    }

    private  static  void usingJoin(){
        Thread[] threads =new Thread[100];
        for (int i = 0; i <threads.length ; i++) {
            int result=0;
            for (int j = 0; j <10000 ; j++) {
               result+=j;
            }
        }

        for (int i = 0; i <threads.length ; i++) {
            threads[i].start();
        }
        for (int j = 0; j <threads.length ; j++) {

            try {
                threads[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end join");
    }

}
