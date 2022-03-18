package Collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * HashSet ：对集合的迭代顺序不做任何保证
 */
public class SetDemo {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        set.add("1");
//        set.add("2");
//        set.add("3");
//        set.add("4");
//        set.add("WST");
//        set.add("JYQ");
//        set.add("XQQ");
//        set.add("XQQ");
//        set.add("LK");
//        set.add("LK2");
//        //输出结果顺序与输入不同
//        for(String s : set){
//            System.out.println(s.hashCode()+" "+s);
//        }

        //产生不重复随机数
        Set<Integer> set = new HashSet<>();
        Random r = new Random();
        while(set.size()<10){
            //产生1-20的随机数
            int num = r.nextInt(20)+1;
            set.add(num);
        }
        for(Integer i :set){
            System.out.println(i);
        }
    }

}
