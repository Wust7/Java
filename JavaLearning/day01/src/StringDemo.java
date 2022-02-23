public class StringDemo {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        //判断地址是否相同
        System.out.println(s1 == s2);
        //判断值是否相等
        System.out.println(s1.equals(s2));
    }
}
