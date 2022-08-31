package duotai;

public class dog extends animal implements Jumpping{
    @Override
    public void eat() {
        System.out.println("狗吃屎");
    }

    @Override
    public void jump() {
        System.out.println("狗跳起来了");
    }
}
