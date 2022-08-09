package org.feather;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Thread02
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/6 22:07
 * @version: 1.0
 */
public class Thread02 {

    static  class MyThread extends  Thread{
        @Override
        public void run() {
            System.out.println("hello thread");
        }
    }

    static  class  MyRun implements  Runnable{

        @Override
        public void run() {
            System.out.println(" hello run");
        }
    }

    public static void main(String[] args) {
        new MyThread().run();
        new  Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("hello lambda");
        }).start();

    }
}
