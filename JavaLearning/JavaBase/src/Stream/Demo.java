package Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("7中国1");
        list.add("7中国1");
        list.add("6中国2");
        list.add("5中国33");
        list.add("4中国443");
        list.add("3中国52");
        list.add("2中国6");
        list.add("1中国7123412");
        ArrayList<String> listInt = new ArrayList<>();
        listInt.add("10");
        listInt.add("20");
        listInt.add("30");
        listInt.add("40");
        listInt.add("50");
        String[] strArr={"JYQ,22","WST,23","XBB,1"};
////        ArrayList<String> str = new ArrayList<>();
////        for (String s : list) {
////            //测试此字符串是否以指定的前缀开头
////            if(s.startsWith("中")){
////                str.add(s);
////            }
////        }
////        ArrayList<String> str2 = new ArrayList<>();
////        for (String s : str) {
////            if(s.length()==3){
////                str2.add(s);
////            }
////        }
////        for (String s : str2) {
////            System.out.println(s);
////        }
//
//        //改进
//        //Stream流
//        //filter:返回由与此给定谓词匹配的此流的元素组成的流 ---------中间操作
//        //forEach：对此流的每个元素执行操作 ---------终结操作
//        list.stream().filter(s->s.startsWith("中")).filter(s->s.length()==3).forEach(System.out::println);
        /**
         * Stream常用生成方式
         */
//        ArrayList<String> list = new ArrayList<>();
//        Stream<String> listStream = list.stream();
//
//        HashSet<String> hs = new HashSet<>();
//        Stream<String> setStream = hs.stream();
//
//        HashMap<String, Integer> map = new HashMap<>();
//        Stream<String> keypStream = map.keySet().stream();
//        Stream<Integer> valueStream = map.values().stream();
//
//        String[] arrStr = {"hello", "world", "java"};
//        Stream<String> arrStrStream = Stream.of(arrStr);
//        Stream<String> ss = Stream.of("JYQ", "XBB");
//        Stream<Integer> is = Stream.of(19, 29, 39);
        /**
         * filter
         */
//        list.stream().filter(s->s.startsWith("中")).forEach(System.out::println);
//
//        list.stream().filter(s->s.length()==3).forEach(System.out::println);
        //limit:返回由此流的元素组成的流，截短长度不能超过 maxSize
//        list.stream().limit(3).forEach(System.out::println);
//        //在丢弃流的第一个 n元素后，返回由该流的剩余元素组成的流
//        list.stream().skip(2).forEach(System.out::println);
//        list.stream().skip(3).limit(2).forEach(System.out::println);
//        Stream<String> s1 = list.stream().limit(4);
//        Stream<String> s2 = list.stream().skip(2);
        //创建一个懒惰连接的流，其元素是第一个流的所有元素，后跟第二个流的所有元素
//        Stream.concat(s1,s2).forEach(System.out::println);
        //返回由该流的不同元素（根据 Object.equals(Object) ）组成的流
//        Stream.concat(s1,s2).distinct().forEach(System.out::println);
        //返回由此流的元素组成的流，根据自然顺序排序
//        list.stream().sorted().forEach(System.out::println);
        //中间传入比较器：自定义排序方式
//        list.stream().sorted((o1, o2) -> o1.length() - o2.length()).forEach(System.out::println);
        //先按照长度排序 再按照自然方式排序
//        list.stream().sorted((o1, o2) ->{
//            int num=o1.length()-o2.length();
//            int num2=num==0?o1.compareTo(o2):num;
//            return num2;
//        }).forEach(System.out::println);
//        //map:返回由给定函数应用于此流的元素的结果组成的流
//        listInt.stream().map(Integer::parseInt).forEach(System.out::println);
//        //mapToInt:返回一个 IntStream其中包含将给定函数应用于此流的元素的结果
//        listInt.stream().mapToInt(Integer::parseInt).forEach(System.out::println);
//
//        //sum:IntStream中的一个方法，Stream中没有
//        int res = list.stream().mapToInt(Integer::parseInt).sum();
//        long count = list.stream().filter(s -> s.startsWith("7")).count();
//        System.out.println(count);
//        Stream<String> listStream = list.stream().filter(s -> s.length() == 4);
//        //使用 Collector对此流的元素执行 mutable reduction操作
//        List<String> names = listStream.collect(Collectors.toList());
//        for (String name : names) {
//            System.out.println(name);
//
//        }
//
//        HashSet<Integer> set = new HashSet<>();
//        set.add(10);
//        set.add(20);
//        set.add(30);
//        set.add(40);
//        set.add(50);
//        Stream<Integer> setStream = set.stream().filter(age -> age > 30);
//        Set<Integer> ages = setStream.collect(Collectors.toSet());
//        for (Integer age : ages) {
//            System.out.println(age);
//        }
        Stream<String> arrStream = Stream.of(strArr).filter(s -> Integer.parseInt(s.split(",")[1]) > 20);
        Map<String, Integer> map = arrStream.collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        Set<String> setStr = map.keySet();
        for (String s : setStr) {
            System.out.println(s+","+map.get(s));

        }


    }
}
