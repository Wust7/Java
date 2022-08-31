package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map<K,V>:不能包含重复的键
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> m =new HashMap<>();
        m.put("JYQ","WST");
        m.put("JYQ","WST");
        m.put("JYQ2","WST");
        m.put("WLK","WST");
        m.put("JYQ3","WST");
        System.out.println(m);
        //删除指定键元素
        m.remove("JYQ");
        //删除所有元素
//        m.clear();
        //判断是否包含某键
        System.out.println(m.containsKey("JYQ2"));
        System.out.println(m.containsValue("WST"));


        System.out.println(m.size());
        System.out.println(m.isEmpty());
        System.out.println(m);

        System.out.println(m.get("WLK"));

        //获取所有键的集合
        for(String s : m.keySet()){
            System.out.println(s);
        }

        //获取所有值得集合
        for(String s : m.values()){
            System.out.println(s);
        }

        //获取所有键值对元素
        Set<Map.Entry<String, String>> entrySet = m.entrySet();
        for(Map.Entry<String, String> me:entrySet){
            System.out.println(me.getKey()+" "+me.getValue());
        }
    }
}
