package wust;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class leetcode_141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode slow = head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println(true);
            }
        }
        System.out.println(false);


    }
}
