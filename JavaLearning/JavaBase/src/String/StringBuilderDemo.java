package String;

public class StringBuilderDemo {
    /**
     * String:内容不可变
     * StringBulider：内容可变
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:"+sb);
        System.out.println("sb.length::"+sb.length());
        sb.append(3);
        sb.append("wer");
        System.out.println(sb);

        // StringBuilder转换为String
        String s = sb.toString();
        System.out.println(s);

        // String 转换 StringBuilder
        StringBuilder sb2 = new StringBuilder(s);
        System.out.println(sb2);

        //StringBuilder自带反转
        sb2.reverse();
        System.out.println(sb2);

        //String反转
        System.out.println(stringReverse(s));

    }
    public static String stringReverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}
