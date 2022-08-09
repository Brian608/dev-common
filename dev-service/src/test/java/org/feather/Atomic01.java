package org.feather;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Atomic01
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/8 08:29
 * @version: 1.0
 */
public class Atomic01 {
    AtomicInteger count =new AtomicInteger(0);

    void  m(){
        count.incrementAndGet();
    }

    public static void main(String[] args) {

        Atomic01 t=new Atomic01();
        List<Thread> threads=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
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
