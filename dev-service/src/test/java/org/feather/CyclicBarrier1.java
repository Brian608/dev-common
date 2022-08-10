package org.feather;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: CyclicBarrier
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/10 07:56
 * @version: 1.0
 */
public class CyclicBarrier1 {
    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(20, ()-> System.out.println("满人,发车"));

        for (int i = 0; i <100 ; i++) {
            new  Thread(()->{
                try {
                    barrier.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
