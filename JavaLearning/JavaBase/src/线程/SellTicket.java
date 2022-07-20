package 线程;

public class SellTicket implements Runnable{
    /**
     * 多线程安全问题原因：
     * 1.是否是多线程环境
     * 2.是否有共享数据
     * 3.是否有多条语句操作共享数据
     * 解决办法：破坏上面三个条件中的一个
     *
     * 这里采用把多条语句操作共享数据的代码块给锁起来，让任意时刻只能有一个线程执行即可
     * 采用同步代码块
     * 好处：解决多线程的数据安全问题
     * 弊端：当线程很多时，每个线程都会去判断同步上的锁，会耗费资源，降低效率
     */
//    private int tickets = 100;
    static private int tickets = 100;
    private Object obj = new Object();
    private int x = 0;
    @Override
    public void run() {
//        while(true) {
//            if (tickets > 0) {
//                //通过sleep模拟出票时间
//                try {
//                    /**
//                     * 1.相同的票出现多次：
//                     *  t1,t2,t3  假设t1抢到CPU的执行权，在t1线程执行到sleep时阻塞100ms，t2线程抢到了CPU的执行权
//                     *  t2线程就开始执行，同样执行到sleep处也会阻塞100ms，t3线程抢到CPU
//                     *  t3线程就开始执行，同样执行到sleep处也会阻塞100ms
//                     *  假设线程按照顺序醒过来：
//                     *  t1抢到CPU执行权，在控制台输出：窗口1正在出售第100张票
//                     *  t2抢到CPU执行权，在控制台输出：窗口1正在出售第100张票
//                     *  t3抢到CPU执行权，在控制台输出：窗口1正在出售第100张票
//                     *  如果三个程序还是按照顺序执行，就会执行三次Tickets--；最终票变成97
//                     */
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//                tickets--;
//            }
//        }
//        while(true) {
//            if (tickets > 0) {
//                //通过sleep模拟出票时间
//                try {
//                    /**
//                     * 2.出现负票数：
//                     *  t1,t2,t3  假设t1抢到CPU的执行权，在t1线程执行到sleep时阻塞100ms，t2线程抢到了CPU的执行权
//                     *  t2线程就开始执行，同样执行到sleep处也会阻塞100ms，t3线程抢到CPU
//                     *  t3线程就开始执行，同样执行到sleep处也会阻塞100ms
//                     *  假设线程按照顺序醒过来：
//                     *  t1抢到CPU执行权，在控制台输出：窗口1正在出售第1张票
//                     *  假设t1抢到CPU的执行权，就会执行tickets--；tickets=0
//                     *  t2抢到CPU执行权，在控制台输出：窗口1正在出售第0张票
//                     *  假设t2抢到CPU的执行权，就会执行tickets--；tickets=-1
//                     *  t3抢到CPU执行权，在控制台输出：窗口1正在出售第-1张票
//                     *  若t2继续拥有CPU执行权，就会执行tickets--;tickets=-2
//                     *  如果三个程序还是按照顺序执行，就会执行三次Tickets--；最终票变成97
//                     */
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//                tickets--;
//            }
//        }
//        while(true) {
//            //三个进程需要同一把锁
//            /**
//             * tickets=100,t1,t2,t3
//             * 假设t1抢CPU的执行权，t1开始执行，运行到锁处时，将代码块锁起来
//             * 运行到sleep会阻塞100ms，其他线程会抢到CPU
//             * 若t2抢到CPU执行代码，当运行到锁处时，发现代码块被锁，故进入挂起
//             *
//             * 故需要等t1运行完成后，其他线程才能抢到CPU和资源（锁中代码块）
//             */
//            synchronized (obj) {
//                if (tickets > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//                    tickets--;
//                }
//            }
        while (true) {
            if (x % 2 == 0) {
//                synchronized (obj) {
//                    if (tickets > 0) {
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//                        tickets--;
//                    }
//                }
//                synchronized (this) {
                synchronized (SellTicket.class) {
                    if (tickets > 0) {

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                        tickets--;
                    }
                }
//                sellTicket();
            } else {
//                synchronized (obj) {
//                    if (tickets > 0) {
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//                        tickets--;
//                    }
//                }
                sellTicket();
            }
            x++;
        }
    }

//    private void sellTicket() {
//        synchronized (obj) {
//            if (tickets > 0) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//                tickets--;
//            }
//        }
//    }

    // 同步方法
    //同步方法锁对象是this,故同一代码块都要用this作为对象锁起来
//    private synchronized void sellTicket() {
//        if (tickets > 0) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//            tickets--;
//        }
//    }

    //直接静态方法肯定会出错，故需要加上锁，加上锁同样也有问题，因为静态方法所指向的对象为SellTicket.class,故同样调用的话也要改为该锁对象
    private static synchronized void sellTicket() {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
            tickets--;
        }
    }
}
