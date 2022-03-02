package Collection;

import java.util.ArrayList;

public class ForDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        for(Integer i : arr){
            System.out.println(i);
        }
    }
}
