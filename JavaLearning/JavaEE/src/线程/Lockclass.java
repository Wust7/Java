package 线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lockclass implements Runnable{
    static private int tickets = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true) {
            // 一般使用try - finally块来实现加锁和解锁，以免代码出问题，锁没有被释放
            try {
                //把多条共同执行的代码锁住
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                    tickets--;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
