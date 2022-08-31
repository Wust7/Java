package 线程.Thread_ProducerConsumer;

public class Cosumer implements Runnable{
    private Box b;
    public Cosumer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        while(true){
            b.get();
        }
    }
}
