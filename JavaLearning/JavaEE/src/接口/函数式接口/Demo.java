package 接口.函数式接口;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口：有且仅有一个抽象方法的接口
 */
public class Demo {
    public static void main(String[] args) {
//        MyInterface my = ()-> System.out.println("函数式接口");
//        my.show();
//        my.show();
//        //匿名内部类
//        startThread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"线程启动了");
//            }
//        });
//        //Lambda表达式
//        //函数式接口作为形参可以直接当参数传递
//        startThread(()-> System.out.println(Thread.currentThread().getName()+"线程启动了"));
//        //构造使用场景
//        //定义集合，存储字符串元素
//        ArrayList<String> array = new ArrayList<>();
//        array.add("JYQ555");
//        array.add("JYQ6666");
//        array.add("J1");
//        array.add("JY2");
//        array.add("JYQ3");
//        array.add("JYQ44");
//        System.out.println(array);
////        Collections.sort(array);
//        Collections.sort(array,getComparator());
//        System.out.println(array);
//        String s = getString(() -> "焦余庆");
//        System.out.println(s);
//        Integer i= getInteger(()->24);
//        System.out.println(i);
//        int[] arr={23,123,432,54};
//        System.out.println(getMax(() -> {
//            int max = arr[0];
//            for (int i = 1; i < arr.length; i++) {
//                if (arr[i] > max) {
//                    max = arr[i];
//                }
//            }
//            return max;
//        }));
//        operatorString("JYQ",(String s)-> System.out.println(s));
//        operatorString("JYQ",s-> System.out.println(s));
//        operatorString("JYQ",System.out::println);
//        operatorString("JYQ",s->{
//            System.out.println(new StringBuilder(s).reverse().toString());
//        });
//        operatorString("JYQ",s->System.out.println(new StringBuilder(s).reverse().toString()));

//        operatorString2("JYQ",s -> System.out.println(s),
//                s-> System.out.println(new StringBuilder(s).reverse().toString()));
//        String[] arr={"JYQ,20","WST,22","WSY,1"};
//        printInfo(arr,s->System.out.print(s.split(",")[0]+","),
//                s->System.out.println(s.split(",")[1]));
//        System.out.println(checkString("hello", s -> s.length() > 8));
//        System.out.println(checkString2("JYQXBB", s -> s.length() > 4, s -> s.length() < 0));
//        String[] strArray = {"JYQ,21", "JY,24", "JYQBBB,2", "JYQA,210"};
//        System.out.println(myFilter(strArray, s -> s.split(",")[0].length() > 2,
//                s -> Integer.parseInt(s.split(",")[1]) > 20));
//        convert("100",s->Integer.parseInt(s));
//        convert("100",Integer::parseInt);
//        convert2(100,i->String.valueOf(i+566));
//        convert3("100",s->Integer.parseInt(s),i->String.valueOf(i));
        convert4("JYQ,20",s->s.split(",")[1],i->Integer.parseInt(i),i->(i+20));
    }

    private static void convert4(String s,Function<String,String>fun1,Function<String,Integer>fun2,Function<Integer,Integer>fun3) {
        System.out.println(fun1.andThen(fun2).andThen(fun3).apply(s));
    }

    private static void convert3(String s,Function<String,Integer>fun1,Function<Integer,String>fun2) {
        Integer i = fun1.apply(s);
        String ss = fun2.apply(i);
        System.out.println(ss);
        System.out.println(fun1.andThen(fun2).apply(s));
    }

    private static void convert2(int i,Function<Integer,String>fun) {
        String s = fun.apply(i);
        System.out.println(s);

    }

    //将此函数应用于给定的参数
    private static void convert(String s, Function<String,Integer> fun) {
        Integer i = fun.apply(s);
        System.out.println(i);
    }

    private static ArrayList<String> myFilter(String[] strArray, Predicate<String> pre1, Predicate<String> pre2) {
        ArrayList<String> arr = new ArrayList<>();
        for (String str : strArray) {
            if (pre1.and(pre2).test(str)) {
                arr.add(str);
            }
        }
        return arr;
    }

    //同一个字符串给出两个不同的判断条件
    private static boolean checkString2(String s, Predicate<String> pre1, Predicate<String> pre2) {
        //与
//        boolean b1 = pre1.test(s);
//        boolean b2 = pre2.test(s);
//        boolean b = b1 && b2;
//        return b;
        //等价于
//        return pre1.and(pre2).test(s);
        //或
        return pre1.or(pre2).test(s);
    }

    //对给定的参数进行判断（判断逻辑由lambda表达式实现），返回一个布尔值
    private static boolean checkString(String s, Predicate<String> pre) {
//        return pre.test(s);//正向判断
//        return !pre.test(s);//反向判断
        return pre.negate().test(s);//反向判断
    }

    private static void printInfo(String[] strArray, Consumer<String> con1, Consumer<String> con2) {
        for (String s : strArray) {
            con1.andThen(con2).accept(s);
        }
    }

    //返回一个组成的 Consumer ，依次执行此操作，然后执行 after操作
    private static void operatorString(String name, Consumer<String> con) {
        con.accept(name);
    }

    private static void operatorString2(String name, Consumer<String> con, Consumer<String> con2) {
//        con.accept(name);
//        con2.accept(name);
        //等价于
        con.andThen(con2).accept(name);
    }

    private static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    private static Integer getInteger(Supplier<Integer> sup) {
        return sup.get();
    }

    //Supplier接口：放回一个字符串数据
    private static String getString(Supplier<String> sup) {
        return sup.get();
    }

    private static void startThread(Runnable r) {
//        Thread t = new Thread(r);
//        t.start();
        //等价于
        new Thread(r).start();
    }

    private static Comparator<String> getComparator() {
        //匿名内部类
//        Comparator<String> comp = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        };
//        return comp;
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        };
        //lambda表达式
//        return (String s1,String s2)->{
//            return s1.length()-s2.length();
//        };
        return (s1, s2) -> s1.length() - s2.length();
    }

}
