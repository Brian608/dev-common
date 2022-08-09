package org.feather;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Atomic03
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/9 06:29
 * @version: 1.0
 */
public class Atomic03 {
    static  long count2=0L;

    static AtomicLong count1=new AtomicLong(0L);

    static LongAdder count3=new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread [] threads =new Thread[1000];

        for (int i = 0; i <threads.length ; i++) {
            threads[i]=new Thread(()->{
                for (int j = 0; j <100000 ; j++) {
                    count1.incrementAndGet();
                }
            });
        }

        long start=System.currentTimeMillis();

        for (Thread t: threads) {t.start();}

        for (Thread t: threads) {t.join();}
        long end =System.currentTimeMillis();

        System.out.println("Atomic:"+count1.get()+"------time-----"+(end-start));
        //------------------------------------------------------------------------
        Object lock= new Object();

        for (int i = 0; i <threads.length ; i++) {
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <100000 ; j++) {
                        synchronized (lock){
                            count2++;
                        }
                    }
                }
            });
        }

        start=System.currentTimeMillis();
        for (Thread t: threads) {t.start();}

        for (Thread t: threads ) {t.join();}

        end=System.currentTimeMillis();

        System.out.println("Sync:"+count2+"-------time----"+(end-start));


        //------------------------------------------------------------------------
        for (int i = 0; i <threads.length ; i++) {
       threads[i]=new Thread(()->{
           for (int j = 0; j <100000 ; j++) {
               count3.increment();
           }
       });
        }

        start=System.currentTimeMillis();
        for (Thread t: threads) {t.start();}

        for (Thread t: threads ) {t.join();}

        end=System.currentTimeMillis();

        System.out.println("LongAdder:"+count3+"-------time----"+(end-start));

    }

}
