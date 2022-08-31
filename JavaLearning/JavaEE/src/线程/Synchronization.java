package 线程;

import java.util.*;

public class Synchronization {
    public static void main(String[] args) {
        //ArrayList不具备同步功能，但Collections.synchronizedList会得到一个同步对象
        List<String> list = Collections.synchronizedList(new ArrayList<String>());


        Map<String,String> map = Collections.synchronizedMap(new HashMap<String,String>());




    }
}
