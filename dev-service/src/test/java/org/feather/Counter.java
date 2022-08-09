package org.feather;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Cunter
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/4 10:52
 * @version: 1.0
 */
public class Counter {
    private final AtomicLong counter=new AtomicLong();

    public  void increase(){
        counter.incrementAndGet();
    }
}
