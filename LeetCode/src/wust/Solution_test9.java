package wust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution_test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[10];
        for (int i = 0; i < m; i++) {
            arr[i]=sc.nextInt();
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if(map.containsKey(arr[i])){
                ArrayList<Integer> list = map.get(arr[i]);
                list.add(i);
                map.put(arr[i],list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i],list);
            }
        }

        ArrayList<Integer> listNum = new ArrayList<>();



        for (int i = 0; i < m; i++) {
//            listNum.add(Integer.parseInt(num[i]));
        }

        String temp ="1";
        int count = 0;
        int[][] end = new int[n][m];
        ArrayList<Integer> tempNum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tempNum.add(i);
        }
//        for (int i = 0; i < m; i++) {
////            end[Integer.parseInt(num[i])][]
//            if(num[i+1].equals(temp)){
//                for (int j = i+; j < m; j++) {
//                    tempNum.remove()
//                }
//            }
//
//        }
    }
}
