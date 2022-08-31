package 线程.Thread_ProducerConsumer;

public class Box {
    private int milk;
    //表示奶箱状态
    private boolean state = false;
    //加上同步关键字，使用wait才不会出异常
    public synchronized void put(int milk){
        //如果有牛奶，等待消费
        if(state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有牛奶，就生产牛奶
        this.milk = milk;
        System.out.println("送奶工将第"+this.milk+"瓶奶放入奶箱");

        //生产完毕之后，修改奶箱状态
        state=true;

        //同时唤醒其他等待线程
        notifyAll();
    }
    public synchronized void get(){
        //如果没有牛奶，等待生产
        if(!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果有牛奶，就消费牛奶
        System.out.println("用户拿到第"+this.milk+"瓶奶放入奶箱");

        //消费完毕之后，修改奶箱状态
        state = false;
        //同时唤醒其他等待线程
        notifyAll();
    }
}
