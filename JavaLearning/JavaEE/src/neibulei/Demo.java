package neibulei;

public class Demo {
    public static void main(String[] args) {
        //内部类为public，可以用下面方式访问
        Outer.Inner i = new Outer().new Inner();
        i.show();

        //内部类为private，可以用成员方法间接访问
        Outer o = new Outer();
        o.method();

    }
}
