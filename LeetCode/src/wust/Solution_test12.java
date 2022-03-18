package wust;

import wust.jianzhi.ListNode;

public class Solution_test12 {
    public static ListNode headInsert(ListNode head,int value){
        ListNode p =new ListNode(value);
        p.next = head;
        return p;
    }
    public static ListNode rearInsert(ListNode head,int value){
        ListNode p=head;
        if(head==null){
            return p;
        }else{
            while(p.next!=null){
                p=head.next;
            }
            p.next = new ListNode(value);
            p.next.next = null;
            return head;
        }
    }
    public static void main(String[] args) {
//        ListNode
    }
}
