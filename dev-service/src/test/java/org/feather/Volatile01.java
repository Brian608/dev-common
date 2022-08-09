package org.feather;


import java.util.concurrent.TimeUnit;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Volatile01
 * @author: feather(杜雪松)
 * @description:
 * @since: 2022/8/7 22:07
 * @version: 1.0
 */
public class Volatile01 {
  volatile   boolean running =true;
    void  m(){
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        Volatile01 t1=new Volatile01();
        new  Thread(t1::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.running=false;
    }
}
