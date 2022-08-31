package 线程;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            //MyRunnable没有继承Thread类，不能直接使用getName
//            System.out.println(getName()+":"+i);
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
