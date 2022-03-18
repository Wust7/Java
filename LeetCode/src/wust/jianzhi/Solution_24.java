package wust.jianzhi;

import java.util.Stack;

public class Solution_24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode next1 = new ListNode(3);
        head.next = next1;
        ListNode next2 = new ListNode(1);
        head.next.next = next2;
        Stack<Integer> s = new Stack<>();
        ListNode p = head;
        while(p!=null){
            s.push(p.val);
            p = p.next;
        }
        ListNode endHead = null;
        ListNode q = new ListNode(0);
        ListNode temp = q;
        while(!s.isEmpty()){
            q.next = new ListNode(s.pop());
            q = q.next;
        }
        while(temp.next!=null){
            System.out.println(temp.next.val);
            temp = temp.next;
        }
    }
}
