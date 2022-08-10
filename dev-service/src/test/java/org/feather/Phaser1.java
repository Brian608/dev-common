package org.feather;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Phaser1
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/10 08:09
 * @version: 1.0
 */
public class Phaser1 {
    static Random r1=new Random();


    static  void millSleep(int mill){
        try {
            TimeUnit.MILLISECONDS.sleep(mill);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

    }
}
