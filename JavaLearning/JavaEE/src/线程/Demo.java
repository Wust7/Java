package 线程;

public class Demo {
    public static void main(String[] args) {
//        MyThread my1 = new MyThread();
//        MyThread my2 = new MyThread();
        // run():封装线程执行的代码，直接调用，相当于普通方法
//        my1.run();
//        my2.run();

        // 导致此线程开始执行; Java虚拟机调用此线程的run方法
        // start():启动线程；然后由JVM调用此线程的run()方法
        /**
         *     public Thread() {
         *         init(null, null, "Thread-" + nextThreadNum(), 0);
         *     }
         *     private static synchronized int nextThreadNum() {
         *         return threadInitNumber++;
         *     }
         *     private static int threadInitNumber;
         *     public Thread(ThreadGroup group, Runnable target, String name,
         *                   long stackSize) {
         *         init(group, target, name, stackSize);
         *     }
         *     this.name = name;
         *
         *
         *     public final synchronized void setName(String name) {
         *         this.name = name;
         *     }
         *
         *     public final String getName() {
         *         return name;
         *     }
         */
//        my1.setName("JYQ");
//        my2.setName("WST");
//        my1.start();
//        my2.start();
        /**
         *     public Thread(String name) {
         *         init(null, null, name, 0);
         *     }
         *     this.name = name;
         */
//        MyThread my1 = new MyThread("JYQ");
//        MyThread my2 = new MyThread("WST");
//        my1.start();
//        my2.start();
//
//        //static Thread currentThread();返回对当前正在执行的线程对象的引用
//        System.out.println(Thread.currentThread());
//        MyThread my1 = new MyThread("父亲");
//        MyThread my2 = new MyThread("儿子");
//        MyThread my3 = new MyThread("女儿");
//        System.out.println(my1.getPriority());
//        System.out.println(my2.getPriority());
//        System.out.println(my3.getPriority());
//
////        IllegalArgumentException - 如果优先级不在 MIN_PRIORITY到 MAX_PRIORITY范围内。
////         数值越大，优先级越高，获取时间片概率越大（1,10）-5
//        my1.setPriority(Thread.MAX_PRIORITY);
//        System.out.println(Thread.MIN_PRIORITY);
//
//        my2.setPriority(1);
//        my3.setPriority(2);
//
//        //设置主线程
//        Thread.currentThread().setName("国家");
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName()+":"+i);
//        }
//        //设置守护线程,当主线程挂掉，java虚拟机退出，守护线程很快就会结束掉
//        my1.setDaemon(true);
//        my2.setDaemon(true);
//        my3.setDaemon(true);
//        my1.start();
//        try {
//            //等待my1死亡后，其他线程才开始执行，注意：要放在start后面，且优先级最高
//            my1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        my2.start();
//        my3.start();

//        MyRunnableDemo();

//        sellTicket();
        lockDemo();
    }

    private static void sellTicket() {
        SellTicket st = new SellTicket();

        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

    private static void MyRunnableDemo() {
        MyRunnable my = new MyRunnable();
//        Thread t1 = new Thread(my);
//        Thread t2 = new Thread(my);
//        Thread(Runnable target, String name)
        Thread t1 = new Thread(my,"WST");
        Thread t2 = new Thread(my,"JYQ");
        t1.start();
        t2.start();



    }

    private static void lockDemo(){
        Lockclass st = new Lockclass();

        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
