package org.feather;

import java.util.concurrent.TimeUnit;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Account
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/7 16:51
 * @version: 1.0
 */
public class Account {
    String  name;

    double balance;

    public  synchronized  void  set(String name,double balance){
        this.name=name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;
    }

    public  double getBalance(String name){
        return  this.balance;
    }


    public static void main(String[] args) {
        Account account=new Account();
        new  Thread(()-> account.set("zhangsan",100.00)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zhangsan"));


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zhangsan"));

    }
}
