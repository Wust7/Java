package jicheng;

public class Demo {
    public static void main(String[] args) {
        //先访问fu中无参再访问zi中无参
        Zi z = new Zi();


        z.method();

        //先访问fu中无参再访问zi中有参，原因是zi类中默认有一条super()代指父类无参
        Zi z2 = new Zi(20);

        //
        final Zi z3 = new Zi();
        z3.age = 10;
        System.out.println(z3.age);
        //final 修饰了name 不能修改
//        z3.name = "JYQ";
        //z3被final了，且z3中存的是地址，故不能修改该地址，但值可以修改
//        z3 = new Zi();
    }
}
