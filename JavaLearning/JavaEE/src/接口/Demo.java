package 接口;

public class Demo {
    public static void main(String[] args) {
//        MyInterfaceImplOne myone = new MyInterfaceImplOne();
//        myone.show1();
//        myone.show2();
//        myone.show3();
        /**
         * 接口中的静态方法只能被接口调用
         * 因为实现类可以实现多个接口，若这些接口中有方法名相同的方法，那么实现类对象调用该相同名称方法时，
         * 分不清该调用哪一个
         */
//        myone.show4();
//        MyInterface.show4();

        usePrintable(s-> System.out.println(s));
        System.out.println("爱你哟");
        // 方法引用符  ::
        usePrintable(System.out::println);
        //可推导的就是可以省略的
    }
    private static void usePrintable(Printable p){
        p.printString("爱你哟");
    }
}
