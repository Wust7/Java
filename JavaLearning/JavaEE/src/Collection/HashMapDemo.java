package Collection;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, List<Integer>> hm = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        hm.put("JYQ1",list1);
        hm.put("JYQ2",list2);
        hm.put("JYQ3",list3);
        for(String s:hm.keySet()){
            System.out.println(s+""+hm.get(s).get(0));
        }

        //获取所有键值对
        Set<Map.Entry<String, List<Integer>>> entrySet = hm.entrySet();
        for(Map.Entry<String, List<Integer>> s:entrySet){
            System.out.println(s.getKey()+" "+s.getValue());
        }


    }
}
