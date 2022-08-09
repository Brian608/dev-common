package org.feather;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Volatile02
 * @author: feather(杜雪松)
 * @description: volatile并不能保证多个线程同时修改running变量所带来的不一致问题
 * @since: 2022/8/8 07:46
 * @version: 1.0
 */
public class Volatile02 {
    volatile  int count=0;
    synchronized void  m(){
        for (int i = 0; i <10000 ; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Volatile02 t=new Volatile02();
        List<Thread> threads=new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            threads.add(new Thread(t::m,"thread-"+i));
        }

        threads.forEach(Thread::start);

        threads.forEach(o->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);


    }
}
