package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //添加元素
        list.add(1);
        list.add(1);
        list.add(121);
        list.add(1432);
        list.add(2,543);
        System.out.println(list);

        Iterator<Integer> i =list.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        //移除元素，返回该元素
        System.out.println(list.remove(3));

        //设置元素，返回被修改元素
        System.out.println(list.set(3,45));

        //获取指定位置元素
        System.out.println(list.get(3));

    }
}
