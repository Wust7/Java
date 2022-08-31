package 线程.Thread_ProducerConsumer;

public class Demo {
    public static void main(String[] args) {
        Box b = new Box();

        Producer p = new Producer(b);

        Cosumer c = new Cosumer(b);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();


    }
}
