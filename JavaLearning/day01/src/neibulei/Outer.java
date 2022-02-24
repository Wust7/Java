package neibulei;

public class Outer {
    private int age = 10;
    public class Inner{
        public void show(){
            System.out.println(age);
        }
    }

    private class Inner2{
        public void show(){
            System.out.println(age);
        }
    }
    public void method(){
        //访问内部类需要创建其对象
        Inner2 i = new Inner2();
        i.show();
    }

}
