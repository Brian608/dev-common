package org.feather;

import java.util.concurrent.TimeUnit;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Thread01
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/6 21:06
 * @version: 1.0
 */
public class Thread01 {
    private static  class T1 extends  Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
       // new T1().run();
        new  T1().start();
        for (int i = 0; i <10 ; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
