package org.feather;

import java.util.concurrent.Semaphore;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Semaphore1
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/10 14:42
 * @version: 1.0
 */
public class Semaphore1 {

    public static void main(String[] args) {
        //允许一个线程同时执行
            Semaphore semaphore=new Semaphore(1);

            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("T1 running");
                    Thread.sleep(200);
                    System.out.println("T1 running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();


            new  Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("T2 running!");
                    Thread.sleep(200);
                    System.out.println("T2 running!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            }).start();


    }
}
