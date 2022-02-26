package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class Demo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();

        c.add("WST");
        c.add("WLK");
        System.out.println(c.add("JYQ"));
        System.out.println(c.remove("JYQ"));

        System.out.println(c.contains("JYQ"));
        System.out.println(c.isEmpty());

//        c.clear();
        System.out.println(c);
    }
}
