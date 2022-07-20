package 枚举;

import java.util.Arrays;
import java.util.EnumSet;

public class Demo {
    public enum color{
        RED,GREEN,BULE
    }
    public static final int RED=0x1;
    public static final int GREEN=0x2;
    public static final int BLUE=0x3;
    public static void main(String[] args) {
        color c=color.RED;
        System.out.println(c);
        System.out.println(c.name());
        //序号
        System.out.println(c.ordinal());
        System.out.println(c.toString());
        System.out.println(Arrays.toString(color.values()));

        EnumSet<color> set = EnumSet.allOf(color.class);
        for (color color : set) {
            System.out.println(color);
        }
    }
}
