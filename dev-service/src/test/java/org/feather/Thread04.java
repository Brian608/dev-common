package org.feather;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Thread04
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/6 22:28
 * @version: 1.0
 */
public class Thread04 {
    static  class MyThread extends  Thread{
        @Override
        public void run() {
            System.out.println(this.getState());
            for (int i = 0; i <10 ; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        }

        public static void main(String[] args) {
            Thread t= new MyThread();

            System.out.println(t.getState());

            t.start();

            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getState());
        }
    }
}
