package org.feather;

import java.util.concurrent.TimeUnit;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: ReentrantLock1
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/9 07:31
 * @version: 1.0
 */
public class ReentrantLock1 {
    synchronized  void  m1(){
        for (int i = 0; i <10 ; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i==2){
                m2();
            }
        }
    }

    synchronized  void  m2(){
        System.out.println("m2");
    }

    public static void main(String[] args) {
        ReentrantLock1 r1=new ReentrantLock1();
        new  Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //new  Thread(r1::m2).start();
    }
}
