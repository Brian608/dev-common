package org.feather;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: ReadWriteLock
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/10 10:09
 * @version: 1.0
 */
public class ReadWriteLock1 {
    static  Lock lock =new ReentrantLock();

    private static  int value;

    static  ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    static  Lock readLock=readWriteLock.readLock();

    static  Lock writeLock=readWriteLock.writeLock();

    public static void  read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public  static  void  write(Lock lock,int v){
        try {
            lock.lock();
            Thread.sleep(10000);
            value=v;
            System.out.println("write over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
       // Runnable readR=()->read(lock);

        Runnable readR=()->read(readLock);

       // Runnable writeR=()->write(lock,new Random().nextInt());

       Runnable writeR=()->write(writeLock,new Random().nextInt());
        for (int i = 0; i < 18; i++) {
            new Thread(readR).start();
        }

        for (int i = 0; i <2 ; i++) {
            new Thread(writeR).start();
        }


    }
}
