package org.feather;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Thread03
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/6 22:13
 * @version: 1.0
 */
public class Thread03 {
    public static void main(String[] args) {

    }
    static  void  testSleep(){
        new  Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("testSleep"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void  testYield(){
        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println("testYield"+i);
                if (i%10==0){
                    Thread.yield();
                }
            }
        }).start();
    }


    static void  testJoin(){
        Thread t1=new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println("testJoin"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
