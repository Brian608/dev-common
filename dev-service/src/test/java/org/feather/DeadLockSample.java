package org.feather;

import java.text.DecimalFormat;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: DeadLockSample
 * @author: feather(杜雪松)
 * @description:死锁例子
 * @since: 2022/8/8 15:10
 * @version: 1.0
 */
public class DeadLockSample  extends  Thread{
    private String first;

    private String second;


    public DeadLockSample(String name,String first,String second){
        super(name);
        this.first=first;
        this.second=second;
    }

    public  void  run (){
        synchronized (first){
            System.out.println(this.getName()+"obtained:"+first);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";

        DeadLockSample t1=new DeadLockSample("Thread1",lockA,lockB);
        DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
        t1.start(); t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
