package org.feather;

import java.util.concurrent.TimeUnit;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: synchronized02
 * @author: feather(杜雪松)
 * @description: 可重入锁
 * @since: 2022/8/7 17:26
 * @version: 1.0
 */
public class Synchronized02 {
    synchronized  void  m1(){
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }

    synchronized  void  m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        new Synchronized02().m1();
    }
}
