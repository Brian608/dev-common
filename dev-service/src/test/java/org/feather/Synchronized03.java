package org.feather;

import java.util.concurrent.TimeUnit;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: synchronized02
 * @author: feather(杜雪松)
 * @description: 锁定某对象o，如果对象的属性发生变化，不影响锁的使用
 * 如果对象发生变更为其他对象，则锁定的对象发生变化
 * 应该避免将锁定的对象变化为其他对象
 * @since: 2022/8/7 17:26
 * @version: 1.0
 */
public class Synchronized03 {

    //final Object o=new Object();
    Object o=new Object();

    void  m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }

        }
    }

    public static void main(String[] args) {
        Synchronized03 t= new Synchronized03();

        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //创建第二个线程
        Thread t2=new Thread(t::m,"t2");

        //锁对象发生变化，所以线程t2得执行，如果注视这行代码，线程t2 永远得不到执行机会
        t.o=new Object();

        t2.start();


    }
}
