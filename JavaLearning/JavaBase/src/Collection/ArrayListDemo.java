package Collection;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        //添加元素
        arrayList.add("JYQ");
        arrayList.add("JYQ");
        arrayList.add("JYQ");
        arrayList.add("WLK");

        arrayList.add(2,"WST");

        //删除元素
        arrayList.remove(1);
        System.out.println(arrayList);

        arrayList.remove("JYQ");//只删除第一个，不是所有
        System.out.println(arrayList);

        //获取元素
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.contains("WLK1"));
    }
}
