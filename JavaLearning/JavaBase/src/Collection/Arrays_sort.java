package Collection;

import org.junit.Test;

import java.util.Arrays;

public class Arrays_sort {
    @Test
    public void Test1(){
        int[] a = {12,34,224,76,45};
        Arrays.sort(a);//默认递增
        System.out.println(Arrays.toString(a));
    }
}
