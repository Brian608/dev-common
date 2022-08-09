package org.feather;

/**
 * @projectName: dev-common
 * @package: org.feather
 * @className: Mgr03
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/8/7 22:38
 * @version: 1.0
 */
public class Mgr03 {
    private static  Mgr03 INSTANCE;

    private Mgr03(){

    }

    public  static synchronized Mgr03 getInstance(){
        if (INSTANCE==null){
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE=new Mgr03();
        }
        return  INSTANCE;
    }

    public  void  m (){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {

            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
