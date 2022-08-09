package org.feather;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: ReentrantLock3
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/9 07:51
 * @version: 1.0
 */
public class ReentrantLock3 {

    Lock lock =new ReentrantLock();

    void  m1(){
        try {
            lock.lock();
            for (int i = 0; i <10 ; i++) {

                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 使用try lock 进行尝试锁定，不管锁定与否都将继续执行
     * 可以根据try lock的返回值进行判断是否锁定
     * 也可以指定try lock的时间，由于try lock 跑出异常，所以注意try lock 的
     */
    void  m2(){
        boolean locked=false;
        try {
          locked=  lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2----"+locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (locked){
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        ReentrantLock3 r3=new ReentrantLock3();
        new  Thread(r3::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r3::m2).start();

    }
}
