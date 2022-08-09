package org.feather;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: ReentrantLock4
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/9 08:00
 * @version: 1.0
 */
public class ReentrantLock4 {


    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Thread t1=new Thread(()->{
            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("t1  Interrupted");
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2=new Thread(()->{
            try {
              //  lock.lock();
                lock.lockInterruptibly();
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("t2  Interrupted");
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打断线程2 的等待
        t2.interrupt();
    }
}
