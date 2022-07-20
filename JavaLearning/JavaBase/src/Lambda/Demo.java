package Lambda;

public class Demo {
    /**
     * 注意事项：
     *  1.使用Lambda必须要有接口，并且要求接口中有且仅有一个抽象方法
     *  2.必须有上下文环境，才能推导出Lambda对应接口
     *  匿名内部类会产生一个单独的.class文件，而Lambda表达式则不会
     * @param args
     */
    public static void main(String[] args) {
        //实现类的方式
//        MyRunnable my = new MyRunnable();
//        Thread t = new Thread(my);
//        t.start();

//        //匿名内部类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("匿名内部类多线程启动");
//            }
//        }).start();
//
//        //lambda表达式
//        new Thread(()->{
//            System.out.println("匿名内部类多线程启动");
//        }).start();
        Eatable e = new EatableIml();
//        useEatable(e);
//        useFly(e);

        //匿名内部类
//        useEatable(new Eatable() {
//            @Override
//            public void eat() {
//                System.out.println("jyq");
//            }
//        });
//        useFly(new Eatable() {
//            @Override
//            public void fly(String s) {
//                System.out.println(s);
//            }
//        });


        //lambda
//        useEatable(()->{
//            System.out.println("wst");
//        });
//        useFly((String s)->{
//            System.out.println(s);
//        });
        //如果有且只有一个参数，那么小括号也可以省略
        //useFly(s->{
//            System.out.println(s);
//        });
        //如果代码块的语句只有一条，可以省略大括号和分号
        //useFly(s->System.out.println(s));
        addtest((int x,int y)->{
            return x+y;
        });
        //省略类型，要么都省略，要么都不省略
        addtest((x,y)->{
            return x+y;
        });
        //如果代码块的语句只有一条，可以省略大括号和分号，若有return，同样也得省略
        addtest((x,y)->x+y);

        //必须有上下文环境，才能推导出Lambda对应接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }).start();

        Runnable r= ()-> System.out.println("hello");
        new Thread((r)).start();
        new Thread((()-> System.out.println("hello2"))).start();
    }

//    private static void useEatable(Eatable e) {
//        e.eat();
//    }
//    private static void useFly(Eatable e){
//        e.fly("起飞1");
//    }
    private static void addtest(Eatable e){
        int sum=e.add(10,20);
        System.out.println(sum);
    }
}
