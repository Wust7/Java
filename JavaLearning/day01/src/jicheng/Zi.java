package jicheng;

public class Zi extends Fu{
    public int age = 20;

    //final为最终得意思，不能被修改，修饰函数为不能重写函数
    public  final String name = "WLK";
    public Zi(){
        System.out.println("zi无参");
    }
    public Zi(int a){
        System.out.println("zi中有参");
    }
    public void method(){
        int age = 30;
        //error
//        name = "JYQ";
        System.out.println(age);
        System.out.println(this.age);
        //访问父类
        System.out.println(super.age);
        super.show();
    }
}
