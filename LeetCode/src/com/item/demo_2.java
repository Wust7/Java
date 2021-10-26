package com.item;

public class demo_2 {
    public ListNode add(ListNode l1,ListNode l2){
        ListNode L = null;
        ListNode p =null;
        while(l1!=null&&l2!=null){
            L = new ListNode(l1.val+l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 ==null&&l2!=null){
            ;
        }
        return null;
    }
}
