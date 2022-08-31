package 泛型;

public class Demo {
    public static void main(String[] args) {
        GenericDemo<Integer> g= new GenericDemo<>();
        g.setT(10);
        System.out.println(g.getT());
        g.show(10);
        GenericDemo<String> g2= new GenericDemo<>();
        g2.show("JYQ");
    }
}
