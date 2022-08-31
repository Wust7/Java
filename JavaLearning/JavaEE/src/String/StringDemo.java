package String;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        for (int i = 0; i < 3; i++) {
            System.out.println(line.charAt(i));
        }
    }
}

//public class String.StringDemo {
//    public static void main(String[] args) {
//        String s1 = "abc";
//        String s2 = "abc";
//        //判断地址是否相同
//        System.out.println(s1 == s2);
//        //判断值是否相等
//        System.out.println(s1.equals(s2));
//    }
//}
