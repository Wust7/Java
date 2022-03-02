package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator:返回集合中元素的迭代器，通过集合的iterator()获取
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("WLK");
        c.add("WLK1");
        c.add("WLK2");
        c.add("WLK3");
        Iterator<String> i = c.iterator();
        //返回集合中的下一个元素
        System.out.println(i.next());
        System.out.println(i.next());
        //判断迭代器中是否有更多元素
        System.out.println(i.hasNext());
    }
}
