package wust.jianzhi;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution_9 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public Solution_9() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    public void appendTail(int value){
        s1.push(value);
    }
    public int deleteHead(){
        if(!s2.isEmpty()){
            return s2.pop();
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.isEmpty()?-1:s2.pop();
        }
    }
}
