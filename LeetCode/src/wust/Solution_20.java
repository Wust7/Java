package wust;

import java.util.Stack;

public class Solution_20 {
    public static void main(String[] args) {
        String s = "}";
        Stack<Character> list = new Stack<>();
        for(int i = 0;i<s.length();i++){
            System.out.println(s.charAt(i));
            if(s.charAt(i) == '('||s.charAt(i) == '{'||s.charAt(i) == '['){
                list.push(s.charAt(i));
            } else if(!list.empty()){
                char c = list.pop();
                if(!((c =='(' && s.charAt(i) == ')')||
                        (c =='{' && s.charAt(i) == '}')||(c =='[' && s.charAt(i) == ']'))){
                    System.out.println("false");
                }
            } else if(list.empty()){
                System.out.println("false2");
            }
        }
        if(!list.empty())
            System.out.println("false");
        System.out.println("true");
    }
}
