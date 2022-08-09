package org.feather;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: synchronized01
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/7 10:22
 * @version: 1.0
 */
public class Synchronized01 {

    private  int count=10;

    public  void  test(){
        //任何线程要执行下面的代码，都必须要拿到this的锁
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+"-------count="+count);
        }
    }
}
