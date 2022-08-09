package org.feather;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: ReentrantLock5
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/9 08:17
 * @version: 1.0
 */
public class ReentrantLock5  extends  Thread{
    //穿参为true 代表公平锁
    private  static ReentrantLock lock =new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"获得锁🔒");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
         ReentrantLock5 r5=new ReentrantLock5();

         Thread t1=new Thread(r5);

         Thread t2=new Thread(r5);

         t1.start();

         t2.start();
    }
}
