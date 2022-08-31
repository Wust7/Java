package 线程;

public class MyThread extends Thread{

    MyThread(){}
    MyThread(String name){
        // 调用父类带参构造方法
        super(name);
    }
    @Override
    public void run() {
        /**
         * 封装被线程执行的代码
         * 如果这个线程是使用单独的Runnable运行对象构造的，那么这个Runnable对象的run方法被调用; 否则，此方法不执行任何操作并返回。
         */
        for (int i = 0; i < 30; i++) {
            //getName():获取线程名称
            System.out.println(getName()+":"+i);
            try {
                //让线程在此处停留1000 ms
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
