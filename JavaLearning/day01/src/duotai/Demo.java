package duotai;

public class Demo {
    public static void main(String[] args) {
        //有父类引用指向子类，向上转型
        animal a = new cat();

        //成员变量：编译看左边，运行看左边
        System.out.println(a.age);//10
//        System.out.println(a.weight);


        //访问成员方法:编译看左边，运行看右边
        a.eat();
//        a.test();

        //多态的好处与弊端
        animalOp op = new animalOp();
        animal cat = new cat();
        animal dog = new dog();
        op.useAnimal(cat);
        op.useAnimal(dog);

        //向下转型
        cat c = (cat) a;
        c.test();

        /**
         * 抽象类的子类要么重写所有抽象方法，要么子类为抽象方法
         * 成员变量：可以是常量、变量
         * 构造方法：有构造，但不能实例化，作用用于子类访问父类数据的初始化
         * 成员方法：抽象、非抽象都可以有
         */
        //抽象类是不具体的，不能创建对象
//        thing t = new thing();
        //可以通过抽象类的子类对象来实例化
        thing t =new animal();

        /**
         * 接口是抽象的内容,不能直接实例化
         * 类只能继承单个父类，类可以实现多个接口，接口可以继承多个接口
         * 接口对行为进行抽象，抽象类对类（包括属性和行为）进行抽象
         */
        dog d = new dog();
        d.jump();

        //同样可以通过其实现类来实例化
        Jumpping jumpping = new dog();
        jumpping.jump();
        //error，接口中的变量默认被public static final修饰,
//        jumpping.age = 12;
        System.out.println(Jumpping.age);
        System.out.println(jumpping.age);


        /**
         * Object为超类，所有类都继承该类
         */


    }
}
