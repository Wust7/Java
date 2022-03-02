package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator可沿任意方向遍历列表
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("4");
        list.add("6");
        list.add("9");
        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        //此时指针已指向最后，故可通过previous从后往前查
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

        //list迭代器有add方法
        listIterator.add("wst");
    }
}
