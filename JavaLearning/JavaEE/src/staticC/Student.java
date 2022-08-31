package staticC;

final public class Student {
    public int score;
    public static int age;
    public void show(){
        System.out.println(age);
    }
    public static void test(){}
    public static void fun(){
//        //error,静态成员方法只能访问静态成员变量和静态成员方法
//        System.out.println(score);
//        show();
        System.out.println(age);
        test();
    }
}
