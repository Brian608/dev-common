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
public class Mgr04 {
    private static volatile  Mgr04 INSTANCE;

    private Mgr04(){

    }

    public  static synchronized Mgr04 getInstance(){
        if (INSTANCE==null){
            //双重检查
            synchronized (Mgr04.class){
                if (INSTANCE==null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE=new Mgr04();
                }
                }

        }
        return  INSTANCE;
    }

    public  void  m (){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {

            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
