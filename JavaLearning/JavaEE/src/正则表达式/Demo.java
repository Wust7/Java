package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        //将给定的正则表达式编译为模式
        Pattern p = Pattern.compile("a*b");
        //创建一个匹配器，匹配给定的输入与此模式
        Matcher m = p.matcher("aaaab");
        //尝试将整个区域与模式进行匹配
        boolean b = m.matches();
        System.out.println(b);

        String s="142134123";
        // [0-9]表示该位置为0-9中的一个数
        // +表示一个或多个
        boolean m1 = s.matches("[0-9]+");
        // \\d十进制数
        boolean m2 = s.matches("\\d+");
        System.out.println(m1+","+m2);

        String phoneNumber="012-15927914991";
        //{3,4}表示有3至4位
        boolean p1 = phoneNumber.matches("\\d{3,4}-\\d{11,12}");
        System.out.println(p1);

        String phone="15927914991";
        System.out.println(phone.matches("1[3-9]\\d{9}"));

        String username="wst_123";
        // \\w等价于[A-Za-z0-9_]
        // |或者
        // * 表示0个或无数个
        //[a-zA-Z]表示该位置为小写字符或大写字符
        System.out.println(username.matches("[a-zA-Z]+[\\w|_]*"));
        System.out.println(username.matches("[a-zA-Z]+[A-Za-z0-9_]*"));

        String ip = "20.10.20.123";
        System.out.println(ip.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));

        String addr = "http://www.baidu.com";
        // \\S非空白字符
        System.out.println(addr.matches("http://\\w+.\\w+.\\S*"));
    }
}
