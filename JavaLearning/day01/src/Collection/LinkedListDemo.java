package Collection;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("WLK");
        list.add("WLK1");
        list.add("WLK2");
        list.add("WLK3");
        list.addFirst("WST");
        list.addLast("JYQ");


        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
    }
}
