package wust;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution_test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        ArrayList<Character> sList = new ArrayList<>();
//        Stack<Character> stack = new Stack<>();
//        Stack<Character> sNum = new Stack<>();
        Stack<Map<Character,Integer>> total= new Stack<>();
        for (int i = 0; i < s.length()-1; i++) {
            char a = s.charAt(i);
            char k;
            String v;
            if(a<='Z' && a>='A'){
                k = a;
                for (int i1 = i+1; i1 < s.length(); i1++) {
//                    if(s.charAt(i1))
                }
//                if((s.charAt(i+1)<='Z'&&s.charAt(i+1)>='A')||(s.charAt(i+1)=='('))
            }

        }
    }
}
