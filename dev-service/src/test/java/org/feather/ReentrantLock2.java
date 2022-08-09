package org.feather;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: ReentrantLock2
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/9 07:44
 * @version: 1.0
 */
public class ReentrantLock2 {
    Lock lock= new ReentrantLock();

    void  m1(){
        try {
        lock.lock();
        for (int i = 0; i <10 ; i++) {
                TimeUnit.SECONDS.sleep(1);

            System.out.println(i);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



    void  m2(){
        try {
            lock.lock();
            System.out.println("m2...");
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantLock2 r2=new ReentrantLock2();
        new  Thread(r2::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r2::m2).start();
    }
}
