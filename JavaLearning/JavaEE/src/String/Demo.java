package String;

import org.junit.Test;

public class Demo {
    @Test
    public void Test1() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        //装箱：把基本数据类型转换为对应的包装类类型
        Integer i1 = Integer.valueOf("100");

        //自动装箱
        Integer i2 = 100;
        System.out.println(i1);

        //拆箱
        int i3 = i2.intValue() + 100;

        //自动拆箱2
        int i4 = i2 + 100;

    }

    @Test
    public void Test2(){
        //int--->string
        int a = 100;
        //第一种
        String s = "" + a;
        System.out.println(s);

        //第二种
        String s2 = String.valueOf(a);
        System.out.println(s2);

        //String ---> Integer --->int
        Integer i = Integer.valueOf(s);
        int i2 = i.intValue();
        System.out.println(i2);

        int i3 = Integer.parseInt(s);
    }

    @Test
    public void Test3(){
        String s = "12,21,423,23,231";

        //切分
        String[] strArray = s.split(",");
        for(int i = 0;i<strArray.length;i++){
            System.out.println(strArray[i]);
        }

        //解析String--->int
        int[] arr = new int[strArray.length];
        for (int i = 0;i<arr.length;i++){
            arr[i] = Integer.parseInt(strArray[i]);
        }

        //int --->String
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<arr.length;i++){
            if(i == arr.length-1){
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(",");
            }
        }
        String result = sb.toString();

    }
}
