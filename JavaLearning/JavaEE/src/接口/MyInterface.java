package 接口;

public interface MyInterface {
    void show1();
    void show2();
//    void show3();
    //默认接口方法不会要求其他类重写该方法

    /**
     * 默认方法不是抽象方法，所以不用强制被重写，但是可以被重写，重写的时候去掉default关键字
     * public 可以省略，default不能省略
     */
    public default void show3(){
        System.out.println("Interface中的默认方法");
//        System.out.println("中国1");
//        System.out.println("中国2");
//        System.out.println("中国3");
        show5();
        show6();
    }
    default void show5(){
        System.out.println("中国1");
        System.out.println("中国2");
        System.out.println("中国3");
    }
    static void show6(){
        System.out.println("中国1");
        System.out.println("中国2");
        System.out.println("中国3");
    }
//    public static void show4(){
    static void show4(){
        System.out.println("Interface中的静态方法");
        System.out.println("中国1");
        System.out.println("中国2");
        System.out.println("中国3");
//        show5();
        show6();
    }

}
