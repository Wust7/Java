package Collection;

import java.util.LinkedHashSet;

/**
 * 存储与输出保持一致，不包含相同元素
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("WLK1");
        linkedHashSet.add("WLK2");
        linkedHashSet.add("XQQ");
        linkedHashSet.add("XQQ");
        linkedHashSet.add("JYQ");
        for(String s : linkedHashSet){
            System.out.println(s);
        }
    }
}
