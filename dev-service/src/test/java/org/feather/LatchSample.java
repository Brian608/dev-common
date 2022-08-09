package org.feather;

import java.util.concurrent.CountDownLatch;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: LatchSample
 * @author: feather(杜雪松)
 * @description:
 * 1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
 * CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 * 而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 * 另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
 * 2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 * @since: 2022/8/8 22:19
 * @version: 1.0
 */
public class LatchSample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new FirstBatchWorker(latch));
            t.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SecondBatchWorker(latch));
            t.start();
        }
        //注意这里也是演示目的的逻辑，并不是推荐的协调方式
        while (latch.getCount() != 1) {
            Thread.sleep(100L);
        }
        System.out.println("Wait for first batch finish");
        latch.countDown();
    }
}

    class  FirstBatchWorker implements  Runnable{

        private  CountDownLatch latch;

        public  FirstBatchWorker (CountDownLatch latch){
            this.latch=latch;
        }

        @Override
        public void run() {
            System.out.println("First batch executed!");
            latch.countDown();
        }


    }

    class  SecondBatchWorker implements  Runnable{

        private  CountDownLatch latch;

        public  SecondBatchWorker(CountDownLatch latch){
            this.latch=latch;
        }
        @Override
        public void run() {
            try {
                latch.wait();
                System.out.println("Second batch executed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
