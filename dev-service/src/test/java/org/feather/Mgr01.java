package org.feather;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Mgr01
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/7 22:32
 * @version: 1.0
 */
public class Mgr01 {
    private  static  final  Mgr01 INSTANCE=new Mgr01();

    private  Mgr01(){

    }

    private static  Mgr01 getInstance(){
        return INSTANCE;
    }

    public  void  m (){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1=Mgr01.getInstance();
        Mgr01 m2= Mgr01.getInstance();
        System.out.print(m1==m2);
    }
}
