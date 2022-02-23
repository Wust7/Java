package wust;

import java.util.HashMap;
import java.util.Scanner;

public class Solution_13 {
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            int total = 0;
            HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
            hashMap.put('I',1);
            hashMap.put('V',5);
            hashMap.put('X',10);
            hashMap.put('L',50);
            hashMap.put('C',100);
            hashMap.put('D',500);
            hashMap.put('M',1000);
            for(int i = 0;i<s.length()-1;i++){
                String t = String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1));
                if(t.equals("IV")||t.equals("IX")||t.equals("XL")||t.equals("XC")||t.equals("CD")||t.equals("CM")){
                    System.out.println(t);
                    total-=hashMap.get(s.charAt(i));
                } else{
                    total += hashMap.get(s.charAt(i));
                }
                System.out.println(total);
            }
            total += hashMap.get(s.charAt(s.length()-1));
            System.out.println(total);

        }

    }
}
